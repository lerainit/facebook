package org.finalproject.dto.friend;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class FriendChangeStatusRequestDto {
    @NotNull
    @Min(1)
    private Long id;
    private String status;
}
