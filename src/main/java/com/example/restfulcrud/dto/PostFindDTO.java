package com.example.restfulcrud.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PostFindDTO {
    private String title;
    private String content;
    private int likeCount;
}
