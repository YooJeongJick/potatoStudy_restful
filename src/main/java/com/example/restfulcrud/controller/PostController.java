package com.example.restfulcrud.controller;

import com.example.restfulcrud.dto.PostDTO;
import com.example.restfulcrud.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping()
    public ResponseEntity<String> create(@RequestBody PostDTO postDTO) {
        postService.save(postDTO);
        return ResponseEntity.ok().body("게시글 등록 완료");
    }

}
