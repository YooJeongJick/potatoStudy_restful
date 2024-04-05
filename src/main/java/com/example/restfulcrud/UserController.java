package com.example.restfulcrud;

import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public String create(@RequestParam String name, int age) {
        User user = new User();
        Long userId = userService.save(user);
        return userId + "번 유저 등록 완료";
    }

    @PutMapping("/update")
    public String update(@RequestParam Long id, String name, int age) {
        Long userId = userService.update(id, name, age);
        return userId + "번 유저 수정 완료";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam Long id) {
        userService.remove(id);
        return id + "번 유저 삭제 완료";
    }

    @GetMapping("/read")
    public String read(@RequestParam @Nullable Long id, String name) {
        if(id != null) {
            return userService.findById(id).toString();
        } else {
            return userService.findByName(name).toString();
        }
    }

    @GetMapping("/read/all")
    public String readAll() {
        return userService.findAll().toString();
    }
}