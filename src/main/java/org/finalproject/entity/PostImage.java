package org.finalproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@Entity
@Table(name = "post_images")
public class PostImage extends BaseEntity {
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "post_id")
    @JsonIgnore
    private Post postId;
    @Column(name = "img_url")
    private String imgUrl;

    @Override
    public String toString() {
        return "PostImage{" +
                "postId=" + postId +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
