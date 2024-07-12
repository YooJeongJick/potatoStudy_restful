package com.example.restfulcrud.service;

import com.example.restfulcrud.dto.PostDTO;
import com.example.restfulcrud.entity.Post;
import com.example.restfulcrud.entity.User;
import com.example.restfulcrud.error.ErrorCode;
import com.example.restfulcrud.error.exception.DuplicateException;
import com.example.restfulcrud.repository.PostRepository;
import com.example.restfulcrud.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public void save(Long user_id, PostDTO postDTO) {
        User writer = userRepository.findById(user_id).orElse(null);

//        if (writer == null)
//            throw new DuplicateException("존재하지 않는 유저", ErrorCode.NOT_FOUND_EXCEPTION);

        Post post = postDTO.toEntity();
        Post savePost = postRepository.save(post);
        writer.addPost(savePost);
    }

    public void update(Long id, PostDTO postDTO) {
        Post updatePost = postRepository.findById(id).orElse(null);
        updatePost.update(postDTO);
    }

    public void delete(Long id) { postRepository.deleteById(id); }

    public PostDTO findById(Long id) {
        Post findPost = postRepository.findById(id).orElse(null);
        return PostDTO.builder()
                .title(findPost.getTitle())
                .content(findPost.getContent())
                .build();
    }
}
