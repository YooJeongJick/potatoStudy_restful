package com.example.restfulcrud.service;

import com.example.restfulcrud.entity.Like;
import com.example.restfulcrud.entity.Post;
import com.example.restfulcrud.entity.User;
import com.example.restfulcrud.repository.LikeRepository;
import com.example.restfulcrud.repository.PostRepository;
import com.example.restfulcrud.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class LikeService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final LikeRepository likeRepository;

    public void like(Long user_id, Long post_id) {
    }
}
