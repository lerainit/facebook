package org.finalproject.dto;

import jakarta.persistence.*;
import lombok.*;
import org.finalproject.entity.User;
import org.finalproject.util.NotificationType;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class NotificationDto {

    private Long id;


    private String type;

    private String status;


    private UserDto sender;


    private String content;


    private Long updatedEntityId;


}
