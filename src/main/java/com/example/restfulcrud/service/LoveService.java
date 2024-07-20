package com.example.restfulcrud.service;

import com.example.restfulcrud.entity.Love;
import com.example.restfulcrud.entity.Post;
import com.example.restfulcrud.entity.User;
import com.example.restfulcrud.error.ErrorCode;
import com.example.restfulcrud.error.exception.NotFoundException;
import com.example.restfulcrud.repository.LoveRepository;
import com.example.restfulcrud.repository.PostRepository;
import com.example.restfulcrud.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class LoveService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final LoveRepository loveRepository;

    public String love(Long user_id, Long post_id) {
        User user = userRepository.findById(user_id).orElse(null);
        if (user == null)
            throw new NotFoundException("존재하지 않는 유저", ErrorCode.NOT_FOUND_EXCEPTION);

        Post post = postRepository.findById(post_id).orElse(null);
        if (post == null)
            throw new NotFoundException("존재하지 않는 포스트", ErrorCode.NOT_FOUND_EXCEPTION);

        Love love = loveRepository.findByUserAndPost(user, post);

        if (love == null) {
            love = love.builder()
                    .user(user)
                    .post(post)
                    .count(true)
                    .build();
            loveRepository.save(love);
            post.upLikeCount();
            return "♥";
        }

        loveRepository.delete(love);
        post.downLikeCount();
        return "♡";
    }
}
