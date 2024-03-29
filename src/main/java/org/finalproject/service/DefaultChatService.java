package org.finalproject.service;

import org.finalproject.dto.chat.ChatSpecDto;
import org.finalproject.dto.chat.UserForChatDto;
import org.finalproject.entity.*;
import org.finalproject.repository.ChatRepository;
import org.finalproject.service.jwt.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
//@RequiredArgsConstructor
public class DefaultChatService extends GeneralService<Chat> {

    @Autowired
    private ChatRepository chatRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private GeneralService<User> generalUserService;
    @Autowired
    private GeneralService<Chat> chatService;
    @Autowired
    private GeneralService<User> userGeneralService;

    public List<ChatSpecDto> getChatsForUserExceptUserId() {

        String auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        User user = userService.getByEmail(auth).get();
        List<ChatSpecProjection> projections = chatRepository.getChatsForUser(user.getId());
        List<ChatSpecDto> chatSpecDtoList = projections.stream()
                .map(ChatSpecDto::fromProjection).toList();
        for (ChatSpecDto chat : chatSpecDtoList) {
            List<UserForChatDto> userSpecDtos = findUsersFromChat(chat.getId());
            userSpecDtos.removeIf(userDto -> userDto.getId().equals(user.getId()));
            chat.setChatParticipant(userSpecDtos);
        }
        return chatSpecDtoList;
    }

    public List<Chat> findChatsByParticipant(Long userId, Long loggedUserId) {

        return chatRepository.findChatsByParticipant(userId, loggedUserId);
    }

    public List<UserForChatDto> findUsersFromChat(Long chatId) {

        List<UserSpecProjection> projections = chatRepository.findUsersFromChat(chatId);
        return projections.stream()
                .map(UserForChatDto::fromProjection)
                .collect(Collectors.toList());
    }

    public List<Chat> createNewChat(Long userId) {

        String auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        User loggedUser = userService.getByEmail(auth).get();
        List<Chat> chats = findChatsByParticipant(userId, loggedUser.getId());
        if (chats.isEmpty()) {
            User user = generalUserService.getOne(userId);
            List<User> userList = List.of(user, loggedUser);
            List<Message> messageList = new ArrayList<>();
            List<MessageImage> messageImageList = new ArrayList<>();
            Chat chat = new Chat(messageList, messageImageList, userList);
            Chat newChat = chatService.save(chat);
            loggedUser.getChats().add(newChat);
            generalUserService.save(loggedUser);
            user.getChats().add(newChat);
            generalUserService.save(user);
            chats.add(newChat);
            return chats;
        } else {
            return chats;
        }
    }

    public void deleteChatById(Long chatId) {

        Chat chat = chatService.findEntityById(chatId);
        List<User> users = chat.getUsers();
        for (User user : users) {
            user.getChats().removeIf(userChat -> userChat.getId().equals(chatId));
        }
        chatService.deleteById(chatId);
    }

    public void addUserForChat(Long chatId, Long userId) {

        Chat chat = chatService.findEntityById(chatId);
        User user = userGeneralService.findEntityById(userId);
        List<User> userList = chat.getUsers();
        userList.add(user);
        chat.setUsers(userList);
        Chat chatFromDb = chatService.save(chat);
        user.getChats().add(chatFromDb);
        userGeneralService.save(user);
    }

}
