package com.example.restfulcrud.controller;

import com.example.restfulcrud.dto.PostDTO;
import com.example.restfulcrud.dto.PostFindDTO;
import com.example.restfulcrud.dto.UserDTO;
import com.example.restfulcrud.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("user/{user_id}")
    public ResponseEntity<String> create(@PathVariable Long user_id, @RequestBody PostDTO postDTO) {
        postService.save(user_id, postDTO);
        return ResponseEntity.ok().body("게시글 등록 완료");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id,@RequestBody PostDTO postDTO) {
        postService.update(id, postDTO);
        return ResponseEntity.ok().body("게시글 수정 완료");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        postService.delete(id);
        return ResponseEntity.ok().body("게시글 삭제 완료");
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostFindDTO> findById(@PathVariable Long id) {
        PostFindDTO post = postService.findById(id);
        return ResponseEntity.ok(post);
    }

    @GetMapping("user/{user_id}")
    public ResponseEntity<List<PostFindDTO>> findByUser(@PathVariable Long user_id) {
        List<PostFindDTO> postByUser = postService.findByUser(user_id);
        return ResponseEntity.ok(postByUser);
    }

}
