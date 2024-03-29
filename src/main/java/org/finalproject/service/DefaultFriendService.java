package org.finalproject.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.finalproject.entity.Friend;
import org.finalproject.entity.User;
import org.finalproject.repository.FriendJpaRepository;
import org.hibernate.Session;
import org.finalproject.repository.UserJpaRepository;
import org.finalproject.util.FriendStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class DefaultFriendService extends GeneralService<Friend> {
    private final FriendJpaRepository friendRepository;
    private final UserJpaRepository userJpaRepository;
    @PersistenceContext
    EntityManager entityManager;

    public List<Friend> friendsOfUser(Long userId) {
        List<Friend> friends = friendRepository.friendsOfUser(userId);
        Session session = (Session) entityManager.getDelegate();
        return friends.stream().map((el) -> {
            session.evict(el);
            if (Objects.equals(el.getFriend().getId(), userId)) {
                User tmp = el.getFriend();
                el.setFriend(el.getUser());
                el.setUser(tmp);
            }
            return el;
        }).toList();
    }

    public List<User> suggestedUsersForFriendship(Long userId) {
        return friendRepository.suggestedUsersForFriendship(userId);
    }

    public List<Friend> friendshipRequests(Long userId) {
        return friendRepository.friendsOfUser(userId).stream()
                                .filter(el -> Objects.equals(el.getStatus(), FriendStatus.pending))
                                .toList();
    }

    public List<User> getMutualFriends(Long userId, Long friendId) {
        return friendRepository.getMutualFriends(userId, friendId);
    }

    public Friend update(Friend entity) {
        Friend friend = friendRepository.findEntityById(entity.getId());
        if (friend != null) {
            friend.setStatus(entity.getStatus());
            return super.save(friend);
        } else {
            return null;
        }
    }

    public Friend update(Long id, FriendStatus friendStatus, Long userId, Long friendId) {
        Friend friend = getOne(id);
        if (!Objects.equals(friend.getUser().getId(), userId)) {
            friend.setUser(userJpaRepository.findEntityById(userId));
        }
        if (!Objects.equals(friend.getFriend().getId(), friendId)) {
            friend.setFriend(userJpaRepository.findEntityById(friendId));
        }
        if (friend.getStatus() != friendStatus) {
            friend.setStatus(friendStatus);
        }
        return super.save(friend);
    }

    public Friend saveNewById(Long userId, Long friendId) {
        List<Friend> friends = friendRepository.getFriendByBothID(userId, friendId);
        List<Friend> filteredFriends = friends.stream().filter(el -> (el.getStatus() == FriendStatus.pending
                || el.getStatus() == FriendStatus.accepted)).toList() ;
        if (filteredFriends.size() > 0) {
            return filteredFriends.get(0);
        } else {
            return super.save(new Friend(FriendStatus.pending,
                                            userJpaRepository.findEntityById(userId),
                                            userJpaRepository.findEntityById(friendId)));
        }
    }

    public Friend changeStatus(Long id, String status) {
        Friend friend = friendRepository.findEntityById(id);
        if (friend != null) {
            friend.setStatus(FriendStatus.forValue(status));
            return super.save(friend);
        } else {
            return null;
        }
    }

    public List<Friend> getFriendByName(Long id, String name) {
        List<Friend> friends = friendRepository.getFriendByUserIdFriendName(id, name);
        Session session = (Session) entityManager.getDelegate();
        return friends.stream().map((el) -> {
            session.evict(el);
            if (Objects.equals(el.getFriend().getId(), id)) {
                User tmp = el.getFriend();
                el.setFriend(el.getUser());
                el.setUser(tmp);
            }
            return el;
        }).toList();
    }
}
