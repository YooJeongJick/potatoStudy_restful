package com.example.restfulcrud.entity;

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
}
