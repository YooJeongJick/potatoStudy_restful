package com.example.restfulcrud.entity;

import com.example.restfulcrud.dto.PostDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private long id;

    private String title;
    private String content;

    private int likeCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public void update(PostDTO postDTO) {
        this.title = postDTO.getTitle();
        this.content = postDTO.getContent();
    }

    public void upLikeCount() {
        this.likeCount += 1;
    }
    public void downLikeCount() {
        this.likeCount -= 1;
    }

}
