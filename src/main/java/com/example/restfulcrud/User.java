package com.example.restfulcrud;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String name;
    private int age;
}
