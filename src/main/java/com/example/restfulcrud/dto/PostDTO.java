package com.example.restfulcrud.dto;

import com.example.restfulcrud.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
// update
@AllArgsConstructor
// post
public class PostDTO {
    private String title;
    private String content;

    public Post toEntity() {
        Post post = Post.builder()
                .title(this.title)
                .content(this.content)
                .build();
        return post;
    }

}
