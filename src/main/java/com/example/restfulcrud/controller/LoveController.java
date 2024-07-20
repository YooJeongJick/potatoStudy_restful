package com.example.restfulcrud.controller;

import com.example.restfulcrud.service.LoveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/love")
@RequiredArgsConstructor
public class LoveController {

    private final LoveService loveService;

    @PostMapping("user/{user_id}/post/{post_id}")
    public ResponseEntity<String> love(@PathVariable Long user_id, @PathVariable Long post_id) {
        return ResponseEntity.ok().body(loveService.love(user_id, post_id));
    }

}
