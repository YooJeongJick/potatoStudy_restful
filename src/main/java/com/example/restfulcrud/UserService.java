package com.example.restfulcrud;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // 유저 등록
    public User save(UserDTO userDTO) {
        User user = userDTO.toEntity();
        userRepository.save(user);
        return user;
    }

    // 유저 수정
    public User update(Long id, UserDTO userDTO) {
        User updateUser = userRepository.findById(id).orElse(null);
        updateUser.update(userDTO);
        return updateUser;
    }

    // 유저 삭제
    public void delete(Long id) {
        User deleteUser = userRepository.findById(id).orElse(null);
        userRepository.delete(deleteUser);
    }

    // 유저 검색
    public User findById(Long id) {
        User findUser = userRepository.findById(id).orElse(null);
        return findUser;
    }

    public User findByEmail(String email) {
        User findUser = userRepository.findByEmail(email);
        return findUser;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

}