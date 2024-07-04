package com.example.restfulcrud;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping()
    public String create(@RequestBody UserDTO userDTO) {
        User user = userService.save(userDTO);
        return user.getId() + "번 유저 등록 완료";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id,@RequestBody UserDTO userDTO) {
        User user = userService.update(id, userDTO);
        return user.getId() + "번 유저 수정 완료";
}

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        userService.delete(id);
        return id + "번 유저 삭제 완료";
    }

    @GetMapping("id/{id}")
    public UserDTO findById(@PathVariable Long id) {
        UserDTO user = userService.findById(id);
        return user;
    }

    @GetMapping("email/{email}")
    public UserDTO findByEmail(@PathVariable String email) {
        UserDTO user = userService.findByEmail(email);
        return user;
    }

    @GetMapping("/all")
    public List<User> findAll() {
        List<User> allUser = userService.findAll();
        return allUser;
    }

}