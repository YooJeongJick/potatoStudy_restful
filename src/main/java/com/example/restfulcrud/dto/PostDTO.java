package com.example.restfulcrud.dto;

import com.example.restfulcrud.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class PostDTO {
    private String title;
    private String content;
}
