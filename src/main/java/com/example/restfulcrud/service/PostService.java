package com.example.restfulcrud.service;

import com.example.restfulcrud.dto.PostDTO;
import com.example.restfulcrud.dto.PostFindDTO;
import com.example.restfulcrud.entity.Post;
import com.example.restfulcrud.entity.User;
import com.example.restfulcrud.error.ErrorCode;
import com.example.restfulcrud.error.exception.DuplicateException;
import com.example.restfulcrud.error.exception.NotFoundException;
import com.example.restfulcrud.repository.PostRepository;
import com.example.restfulcrud.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public void save(Long user_id, PostDTO postDTO) {
        User writer = userRepository.findById(user_id).orElse(null);
        if (writer == null)
            throw new NotFoundException("존재하지 않는 유저", ErrorCode.NOT_FOUND_EXCEPTION);

        Post post = Post.builder()
                .user(writer)
                .title(postDTO.getTitle())
                .content(postDTO.getContent())
                .build();
        postRepository.save(post);
    }

    public void update(Long id, PostDTO postDTO) {
        Post updatePost = postRepository.findById(id).orElse(null);
        if (updatePost == null)
            throw new NotFoundException("존재하지 않는 게시글", ErrorCode.NOT_FOUND_EXCEPTION);

        updatePost.update(postDTO);
    }

    public void delete(Long id) {
        Post deletePost = postRepository.findById(id).orElse(null);
        if (deletePost == null)
            throw new NotFoundException("존재하지 않는 게시글", ErrorCode.NOT_FOUND_EXCEPTION);

        postRepository.delete(deletePost);
    }

    public PostFindDTO findById(Long id) {
        Post findPost = postRepository.findById(id).orElse(null);
        if (findPost == null)
            throw new NotFoundException("존재하지 않는 게시글", ErrorCode.NOT_FOUND_EXCEPTION);

        return PostFindDTO.builder()
                .title(findPost.getTitle())
                .content(findPost.getContent())
                .likeCount(findPost.getLikeCount())
                .build();
    }

    public List<PostFindDTO> findByUser(Long user_id) {
        User writer = userRepository.findById(user_id).orElse(null);
        if (writer == null)
            throw new NotFoundException("존재하지 않는 유저", ErrorCode.NOT_FOUND_EXCEPTION);

        List<Post> posts = writer.getPosts();
        if (posts == null)
            throw new NotFoundException("존재하지 않는 게시글", ErrorCode.NOT_FOUND_EXCEPTION);

        return posts.stream()
                .map(post -> PostFindDTO.builder()
                        .content(post.getContent())
                        .title(post.getTitle())
                        .likeCount(post.getLikeCount())
                        .build())
                .collect(Collectors.toList());
    }

}
