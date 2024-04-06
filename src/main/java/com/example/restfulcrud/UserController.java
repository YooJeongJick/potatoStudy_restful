package com.example.restfulcrud;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public String create(@RequestBody UserDTO userDTO) {
        User user = userService.save(userDTO);
        return user.getId() + "번 유저 등록 완료";
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable Long id,@RequestBody UserDTO userDTO) {
        User user = userService.update(id, userDTO);
        return user.getId() + "번 유저 수정 완료";
}

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        userService.delete(id);
        return id + "번 유저 삭제 완료";
    }

    @GetMapping("/read/{id}")
    public User read(@PathVariable Long id) {
        User user = userService.findById(id);
        return user;
    }

    @GetMapping("/read/all")
    public List<User> readAll() {
        List<User> allUser = userService.findAll();
        return allUser;
    }

}