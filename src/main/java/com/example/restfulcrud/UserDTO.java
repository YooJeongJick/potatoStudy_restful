package com.example.restfulcrud;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
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