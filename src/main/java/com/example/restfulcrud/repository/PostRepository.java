package com.example.restfulcrud.repository;

import com.example.restfulcrud.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
