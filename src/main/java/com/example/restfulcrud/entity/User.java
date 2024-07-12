package com.example.restfulcrud.entity;

import com.example.restfulcrud.dto.UserDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String name;
    private int age;
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();

    public void update(UserDTO userDTO) {
        this.name = userDTO.getName();
        this.age = userDTO.getAge();
        this.email = userDTO.getEmail();
    }

    public void addPost(Post post) {
        this.addPost(post);
    }

}
