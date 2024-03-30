package com.example.restfulcrud;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/entitymanager-example/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("")
    public ResponseEntity<?> create(@RequestParam String name, @RequestParam int age) {
        try {
            UserDTO userDTO = new UserDTO();
            userDTO.setName(name);
            userDTO.setAge(age);
            Long userId = userService.save(userDTO);
            return ResponseEntity.ok(userId + "번 유저 등록 완료");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("유저 등록 실패 : " + e.getMessage());
        }
    }

    @PutMapping("")
    public ResponseEntity<?> update(@RequestParam Long id, @RequestParam String name, @RequestParam int age) {
        try {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(id);
            userDTO.setName(name);
            userDTO.setAge(age);
            Long userId = userService.update(id, userDTO);
            return ResponseEntity.ok(userId + "번 유저 수정 완료");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("유저 수정 실패 : " + e.getMessage());
        }
    }

    @DeleteMapping("")
    public ResponseEntity<?> delete(@RequestParam Long id) {
        try {
            userService.remove(id);
            return ResponseEntity.ok(id + "번 유저 삭제 완료");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("유저 삭제 실패 : " + e.getMessage());
        }
    }

    @GetMapping("")
    public ResponseEntity<?> read(@RequestParam(required = false) Long id, @RequestParam(required = false) String name) {
        if (id != null) {
            try {
                UserDTO userDTO = userService.findById(id);
                return ResponseEntity.ok(userDTO);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("ID에 해당하는 유저를 찾을 수 없습니다 : " + e.getMessage());
            }
        } else if (name != null) {
            try {
                UserDTO userDTO = userService.findByName(name);
                return ResponseEntity.ok(userDTO);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("이름에 해당하는 유저를 찾을 수 없습니다 : " + e.getMessage());
            }
        } else {
            return ResponseEntity.badRequest().body("ID 또는 이름을 지정해야 합니다.");
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> readAll() {
        try {
            List<UserDTO> users = userService.findAll();
            return ResponseEntity.ok(users.toString());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("유저 목록을 불러오는 데 실패했습니다 : " + e.getMessage());
        }
    }
}
