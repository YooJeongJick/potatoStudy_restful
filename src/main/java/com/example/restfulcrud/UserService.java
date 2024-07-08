package com.example.restfulcrud;

import ch.qos.logback.core.spi.ErrorCodes;
import com.example.restfulcrud.error.ErrorCode;
import com.example.restfulcrud.error.exception.DuplicateException;
import com.sun.jdi.request.DuplicateRequestException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // 유저 등록
    public void save(UserDTO userDTO) {
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new DuplicateException("이미 존재하는 이메일", ErrorCode.FORBIDDEN_EXCEPTION);
        }

        User user = userDTO.toEntity();
        userRepository.save(user);
    }

    // 유저 수정
    public void update(Long id, UserDTO userDTO) {
        User updateUser = userRepository.findById(id).orElse(null);
        updateUser.update(userDTO);
    }

    // 유저 삭제
    public void delete(Long id) {
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
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

}