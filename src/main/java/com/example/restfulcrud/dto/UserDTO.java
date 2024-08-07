package com.example.restfulcrud.dto;

import com.example.restfulcrud.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class UserDTO {

    private String name;
    private int age;
    private String email;

    public User toEntity() {
        User user = User.builder()
                .name(this.name)
                .age(this.age)
                .email(this.email)
                .build();
        return user;
    }

}