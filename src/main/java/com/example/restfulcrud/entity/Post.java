package com.example.restfulcrud.entity;

import com.example.restfulcrud.dto.PostDTO;
import jakarta.persistence.*;
import lombok.Builder;

@Builder
// post
@Entity
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private long id;

    private String title;
    private String content;

    public void update(PostDTO postDTO) {
        this.title = title;
        this.content = content;
    }
}
