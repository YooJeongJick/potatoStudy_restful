package com.example.restfulcrud.service;

import com.example.restfulcrud.dto.PostDTO;
import com.example.restfulcrud.entity.Post;
import com.example.restfulcrud.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public void save(PostDTO postDTO) {
        Post post = postDTO.toEntity();
        postRepository.save(post);
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
