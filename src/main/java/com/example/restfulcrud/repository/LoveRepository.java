package com.example.restfulcrud.repository;

import com.example.restfulcrud.entity.Love;
import com.example.restfulcrud.entity.Post;
import com.example.restfulcrud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoveRepository extends JpaRepository<Love, Long> {
    Love findByUserAndPost(User user, Post post);
}
