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
<<<<<<< HEAD
        userRepository.deleteById(id);
    }

    // 유저 검색
    public UserDTO findById(Long id) {
        User findUser = userRepository.findById(id).orElse(null);
        return UserDTO.builder()
                .name(findUser.getName())
                .age(findUser.getAge())
                .email(findUser.getEmail())
                .build();
    }

    public UserDTO findByEmail(String email) {
        User findUser = userRepository.findByEmail(email);
        return UserDTO.builder()
                .name(findUser.getName())
                .age(findUser.getAge())
                .email(findUser.getEmail())
                .build();
=======
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
>>>>>>> 462dda54bb297b230009672a6bb5ea913f78deca
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

}