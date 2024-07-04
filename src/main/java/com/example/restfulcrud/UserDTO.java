package com.example.restfulcrud;

import lombok.AllArgsConstructor;
<<<<<<< HEAD
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
=======
import lombok.Getter;

@Getter
>>>>>>> 462dda54bb297b230009672a6bb5ea913f78deca
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