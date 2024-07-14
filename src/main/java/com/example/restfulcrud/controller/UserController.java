package com.example.restfulcrud.controller;

import com.example.restfulcrud.dto.UserDTO;
import com.example.restfulcrud.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping()
    public ResponseEntity<String> create(@RequestBody UserDTO userDTO) {
        userService.save(userDTO);
        return ResponseEntity.ok().body("유저 등록 완료");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id,@RequestBody UserDTO userDTO) {
        userService.update(id, userDTO);
        return ResponseEntity.ok().body("유저 수정 완료");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.ok().body("유저 삭제 완료");
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
        UserDTO userInfo = userService.findById(id);
        return ResponseEntity.ok(userInfo);
    }

    @GetMapping()
    public ResponseEntity<UserDTO> findByEmail(@RequestBody Map<String, String> emailMap) {
        UserDTO userInfo = userService.findByEmail(emailMap.get("email"));
        return ResponseEntity.ok(userInfo);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> findAll() {
        List<UserDTO> allUser = userService.findAll();
        return ResponseEntity.ok(allUser);
    }

}