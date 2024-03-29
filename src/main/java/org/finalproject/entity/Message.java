package org.finalproject.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "images"})
@Getter
@Setter
@Entity
@Table(name = "messages")
public class Message extends BaseEntity {

    @Column(name = "content")
    private String content;
    @Column(name = "chat_entity_id")
    private Long chatId;

    @ManyToOne(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    // @JsonIgnore
    private User sender;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE}, mappedBy = "messageId")
    @LazyCollection(LazyCollectionOption.FALSE)
    //  @JsonIgnore
    private List<MessageImage> images;

    @ManyToOne(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(name = "chat_id")
    //  @JsonIgnore
    // @JsonBackReference
    private Chat chat;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    @JoinTable(
            name = "message_status",
            joinColumns = {@JoinColumn(name = "message_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private List<User> user;

    public Message(String content, User user, Chat chat, Long chatId) {

        this.content = content;
        this.sender = user;
        this.chat = chat;
        this.chatId = chatId;
    }
}
