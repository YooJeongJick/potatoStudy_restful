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
    public String create(@RequestBody UserDTO userDTO) {
        Long userId = userService.save(userDTO);
        return userId + "번 유저 등록 완료";
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable Long id,@RequestBody UserDTO userDTO) {
    Long userId = userService.update(id, userDTO);
    return userId + "번 유저 수정 완료";
}

//
//    @DeleteMapping("/delete")
//    public String delete(@RequestParam Long id) {
//        userService.remove(id);
//        return id + "번 유저 삭제 완료";
//    }
//
//    @GetMapping("/read")
//    public String read(@RequestParam @Nullable Long id, String name) {
//        if(id != null) {
//            return userService.findById(id).toString();
//        } else {
//            return userService.findByName(name).toString();
//        }
//    }
//
//    @GetMapping("/read/all")
//    public String readAll() {
//        return userService.findAll().toString();
//    }
}