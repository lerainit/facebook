package org.finalproject.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.finalproject.dto.*;

import org.finalproject.dto.chat.ChatDto;
import org.finalproject.dto.chat.ChatDtoMapper;
import org.finalproject.dto.friend.FriendDto;
import org.finalproject.dto.friend.FriendDtoMapper;
import org.finalproject.entity.*;
import org.finalproject.filter.JwtFilter;
import org.finalproject.jwt.Email;
import org.finalproject.service.DefaultFriendService;
import org.finalproject.service.DefaultUserService;
import org.finalproject.service.FileUpload;

import org.finalproject.service.GeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@Slf4j
public class UserRestController {
    private final GeneralService<User> userService;

    private final GeneralService<Post> postService;

    private final DefaultFriendService defaultService;

    private final DefaultUserService defaultUserService;

    private final GeneralService<UserImage> imageService;

    private final UserDtoMapper dtoMapper;

    private final PostDtoMapper postMapper;

    private final ChatDtoMapper chatMapper;

    private final JwtFilter jwt;

    private final FriendDtoMapper friendMapper;

    private final FileUpload fileUpload;



    @GetMapping
    public List<UserDto> getAll() {

        return    userService.findAll()
                .stream()
                .map(dtoMapper::convertToDto).collect(Collectors.toList());


    }

    @GetMapping("/{page}/{size}")

    public ResponseEntity<?> findAll(@PathVariable Integer page, @PathVariable Integer size) {
        Sort sort =  Sort.by(new Sort.Order(Sort.Direction.ASC,"id"));
        Pageable pageable = PageRequest.of(page,size,sort);
        List<UserDto> userDtoList  = userService.findAll(pageable).toList()
                .stream()
                .map(dtoMapper::convertToDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(userDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>  getById(@PathVariable("id")  Long  userId) {
        User user = userService.getOne(userId );

        if (user   == null) {
            return ResponseEntity.badRequest().body("User not found");
        }
        return ResponseEntity.ok().body(dtoMapper.convertToDto(user) );
    }

    @GetMapping("/email")
    public ResponseEntity<?>  getByEmail(@RequestBody Email email) {
        Optional<User> userOptional = defaultUserService.getByEmail(email.getEmail());

        if (userOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("User not found");
        }
        return ResponseEntity.ok().body(dtoMapper.convertToDto(userOptional.get()) );
    }

    @GetMapping("/part")
    public ResponseEntity<?>  getByPartOfName(@RequestParam String   part) {
        List<User> userList = defaultUserService.getUserByPartOfName(part);

        if (userList.isEmpty()) {
            return ResponseEntity.badRequest().body("User not found");
        }
        return ResponseEntity.ok().body(userList.stream().map(dtoMapper::convertToDto) );
    }

    @GetMapping("/profile")
    public ResponseEntity<?>  getProfile() {

        String auth  = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> profile  = defaultUserService.getByFullName(auth);

        if (profile.isEmpty()) {
            return ResponseEntity.badRequest().body("User not found");
        }
        return ResponseEntity.ok().body(dtoMapper.convertToDto(profile.get()));
    }

    @GetMapping("/{userId}/friends")
    public ResponseEntity<?>  getFriends(@PathVariable("userId")  Long  userId) {

        List<FriendDto> friendDtoList = defaultService.friendsOfUser(userId)
                .stream()
                .map(friendMapper::convertToDto).collect(Collectors.toList());

        return ResponseEntity.ok().body(friendDtoList);
    }

    @GetMapping("/{id}/chats")
    public ResponseEntity<?>  getChats(@PathVariable("id")  Long  userId) {
        User user = userService.getOne(userId );

        if (user   == null) {
            return ResponseEntity.badRequest().body("User not found");
        }
        List<ChatDto> userChatsDto = user.getChats()
                .stream()
                .map(chatMapper::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(userChatsDto );
    }

    @GetMapping("/chats")
    public ResponseEntity<?>  getAuthorizedUserChats() {
        String auth  = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> profile  = defaultUserService.getByFullName(auth);

        if (profile.isEmpty()) {
            return ResponseEntity.badRequest().body("User not found");
        }
        List<ChatDto> userChatsDto  = profile.get().getChats()
                .stream()
                .map(chatMapper::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(userChatsDto );
    }

    @GetMapping("/{id}/posts")

    public ResponseEntity<?>  getPosts(@PathVariable("id")  Long  userId) {
        User user = userService.getOne(userId );

        if (user   == null) {
            return ResponseEntity.badRequest().body("User not found");
        }

        List<PostDto> userPostsDto = user.getPosts()
                .stream()
                .map(postMapper::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(userPostsDto );
    }

    @PostMapping
    public void create(@RequestBody UserRequestDto user ) {
        userService.save(dtoMapper.convertToEntity(user) );
    }

    @PostMapping("/{id}/image")
    public void uploadImage(@PathVariable Long id,@RequestBody MultipartFile multipartFile ) {
        String imgUrl = null;
        try {
            imgUrl = fileUpload.uploadUserFile(multipartFile,id);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        User user = userService.getOne(id);
        List<UserImage> userImages = user.getUserImages();
        UserImage newImage = new UserImage();
        newImage.setImageUrl(imgUrl);
        userImages.add(newImage);
        user.setUserImages(userImages);
        userService.save(user );
        newImage.setUser(user);
        newImage.setUserId(user.getId());
        imageService.save(newImage);
    }

    @PostMapping("/{id}/avatar")
    public void uploadAvatar(@PathVariable Long id,@RequestBody MultipartFile multipartFile ) {
        String imgUrl = null;
        try {
            imgUrl = fileUpload.uploadUserFile(multipartFile,id);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        User user = userService.getOne(id);
        user.setProfilePicture(imgUrl);
        userService.save(user );
    }

    @PostMapping("/{id}/header")
    public void uploadHeader(@PathVariable Long id,@RequestBody MultipartFile multipartFile ) {
        String imgUrl = null;
        try {
            imgUrl = fileUpload.uploadUserFile(multipartFile,id);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        User user = userService.getOne(id);
        user.setProfileBackgroundPicture(imgUrl);
        userService.save(user );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id")Long id) {
        try {

            userService.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUser(@RequestBody UserRequestDto user) {
        try {
            userService.delete(dtoMapper.convertToEntity(user));
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody UserRequestDto user) {
        try {
            User userEntity = dtoMapper.convertToEntity(user);
            User userDb = userService.getOne(userEntity.getId());
            userDb.setFullName(userEntity.getFullName());
            userDb.setEmail(userEntity.getEmail());
            userDb.setBirthDate(userEntity.getBirthDate());
            userDb.setCity(userEntity.getCity());
            userDb.setProfileBackgroundPicture(userEntity.getProfileBackgroundPicture());
            userDb.setProfilePicture(userEntity.getProfilePicture());
            userDb.setAbout(userEntity.getAbout());
            userDb.setCountry(userEntity.getCountry());
            userDb.setWorkPlace(userEntity.getWorkPlace());
            userService.save(userDb);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PutMapping("/{id}/likes")
    public ResponseEntity<?> addLikes(@RequestParam Long id, @RequestBody PostRequestDto post) {
        try {
            Post postEntity = postService.getOne(post.getId());
            if ( postEntity == null ) {
                return ResponseEntity.badRequest().body("Post not found");
            }
            List<User> likes = postEntity.getLikes();
            User newLike = userService.getOne(id);
            if ( newLike == null ) {
                return ResponseEntity.badRequest().body("User not found");
            }
            if ( likes.contains( newLike ) ) {
                return ResponseEntity.badRequest().body("Already liked");
            }

            likes.add(newLike);
            List<Post> likedPosts = newLike.getLikedPosts();
            likedPosts.add(postEntity);
            newLike.setLikedPosts(likedPosts);
            userService.save(newLike);
            postEntity.setLikes(likes);
            postService.save(postEntity);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PutMapping("/{id}/reposts")
    public ResponseEntity<?> addRepost(@RequestParam Long id, @RequestBody PostRequestDto post) {
        try {
            Post postEntity = postService.getOne(post.getId());
            Set<User> reposts = postEntity.getReposts();
            User newRepost = userService.getOne(id);
            reposts.add(newRepost);
            Set<Post> repostedPosts = newRepost.getReposts();
            repostedPosts.add(postEntity);
            newRepost.setReposts(repostedPosts);
            userService.save(newRepost);
            postEntity.setReposts(reposts);
            postService.save(postEntity);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

}