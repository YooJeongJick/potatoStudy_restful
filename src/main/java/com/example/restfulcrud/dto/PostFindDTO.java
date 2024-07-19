package com.example.restfulcrud.dto;

import lombok.Builder;

@Builder
public class PostFindDTO {
    private String title;
    private String content;
    private int likeCount;
}
