package com.example.restfulcrud.repository;

import com.example.restfulcrud.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
}
