package com.example.restfulcrud.controller;

import com.example.restfulcrud.dto.PostDTO;
import com.example.restfulcrud.service.LikeService;
import com.example.restfulcrud.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/like")
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    @PostMapping("user/{user_id}/post/{post_id}")
    public ResponseEntity<String> like(@PathVariable Long user_id, Long post_id) {
        return ResponseEntity.ok().body("");
    }
}
