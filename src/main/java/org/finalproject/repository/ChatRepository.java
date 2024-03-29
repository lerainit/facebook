package org.finalproject.repository;

import org.finalproject.entity.Chat;
import org.finalproject.entity.ChatSpecProjection;
import org.finalproject.entity.UserSpecProjection;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChatRepository extends RepositoryInterface<Chat>, JpaSpecificationExecutor<Chat> {

    //    @Query(value = "SELECT DISTINCT " +
    //            "c.id AS id, " +
    //            "uc.user_id AS userId, " +
    //            "u.full_name AS fullName, " +
    //            "u.profile_picture AS profilePicture, " +
    //            "m.content AS content, " +
    //            "m.created_date AS lastMessageDate " +
    //            "FROM " +
    //            "chats c " +
    //            "JOIN " +
    //            "users_chats uc ON c.id = uc.chat_id " +
    //            "JOIN " +
    //            "users u ON uc.user_id = u.id " +
    //            "LEFT JOIN " +
    //            "messages m ON c.id = m.chat_id " +
    //            "WHERE " +
    //            "u.id <> :id " +
    //            "AND c.id IN (SELECT cc.chat_id FROM users_chats cc WHERE cc.user_id = :id) " +
    //            "AND m.id IS NULL OR m.id  = ( " +
    //            "SELECT MAX(m2.id) " +
    //            "FROM messages m2 " +
    //            "WHERE m2.chat_id = c.id " +
    //            ")", nativeQuery = true)
    //    List<ChatSpecProjection> getChatsForUserExceptUserId(@Param("id") Long userId);
    @Query(value = "SELECT " +
            "c.id AS id, " +
            "u.id AS userId, " +
            "u.full_name AS fullName, " +
            "u.profile_picture AS profilePicture, " +
            "m.content AS content, " +
            "m.created_date AS lastMessageDate " +
            "FROM chats c " +
            "LEFT JOIN messages m ON c.id = m.chat_id " +
            "LEFT JOIN users u ON m.user_id = u.id " +
            "LEFT JOIN users_chats uc ON c.id = uc.chat_id " +
            "WHERE uc.user_id = :id " +
            "AND (m.id IS NULL OR m.id = (SELECT MAX(m2.id) " +
            "FROM messages m2 " +
            "WHERE m2.chat_id = c.id" +
            "))", nativeQuery = true)
    List<ChatSpecProjection> getChatsForUser(@Param("id") Long userId);

    @Query(value = "SELECT DISTINCT c.* " +
            "FROM chats c " +
            "JOIN users_chats uc ON c.id = uc.chat_id " +
            "JOIN users u ON uc.user_id = u.id " +
            "WHERE u.id = :userId " +
            "AND c.id IN (SELECT cc.chat_id FROM users_chats cc WHERE cc.user_id = :loggedUserId)",
            nativeQuery = true)
    List<Chat> findChatsByParticipant(@Param("userId") Long userId, @Param("loggedUserId") Long loggedUserId);

    @Query(value = "SELECT " +
            "u.id AS id, " +
            "u.full_name AS fullName, " +
            "u.profile_picture AS profilePicture " +
            "FROM users u " +
            "JOIN users_chats uc ON u.id = uc.user_id " +
            "WHERE uc.chat_id = :id", nativeQuery = true)
    List<UserSpecProjection> findUsersFromChat(@Param("id") Long chatId);

}
