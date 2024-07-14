package com.example.restfulcrud.service;

import com.example.restfulcrud.dto.UserDTO;
import com.example.restfulcrud.entity.User;
import com.example.restfulcrud.error.ErrorCode;
import com.example.restfulcrud.error.exception.DuplicateException;
import com.example.restfulcrud.error.exception.NotFoundException;
import com.example.restfulcrud.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void save(UserDTO userDTO) {
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new DuplicateException("이미 존재하는 이메일", ErrorCode.FORBIDDEN_EXCEPTION);
        }

        User user = userDTO.toEntity();
        userRepository.save(user);
    }

    public void update(Long id, UserDTO userDTO) {
        User updateUser = userRepository.findById(id).orElse(null);
        if (updateUser == null)
            throw new NotFoundException("존재하지 않는 유저", ErrorCode.NOT_FOUND_EXCEPTION);
        if (!updateUser.getEmail().equals(userDTO.getEmail())) {
            if (userRepository.existsByEmail(userDTO.getEmail()))
             throw new NotFoundException("이미 존재하는 이메일", ErrorCode.FORBIDDEN_EXCEPTION);
        }

        updateUser.update(userDTO);
    }

    public void delete(Long id) {
        User deleteUser = userRepository.findById(id).orElse(null);
        if (deleteUser == null)
            throw new NotFoundException("존재하지 않는 유저", ErrorCode.NOT_FOUND_EXCEPTION);

        userRepository.delete(deleteUser);
    }

    public UserDTO findById(Long id) {
        User findUser = userRepository.findById(id).orElse(null);
        if (findUser == null)
            throw new NotFoundException("존재하지 않는 유저", ErrorCode.NOT_FOUND_EXCEPTION);

        return UserDTO.builder()
                .name(findUser.getName())
                .age(findUser.getAge())
                .email(findUser.getEmail())
                .build();
    }

    public UserDTO findByEmail(String email) {
        User findUser = userRepository.findByEmail(email);
        if (findUser == null)
            throw new NotFoundException("존재하지 않는 유저", ErrorCode.NOT_FOUND_EXCEPTION);

        return UserDTO.builder()
                .name(findUser.getName())
                .age(findUser.getAge())
                .email(findUser.getEmail())
                .build();
    }

    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> UserDTO.builder()
                        .name(user.getName())
                        .age(user.getAge())
                        .email(user.getEmail())
                        .build())
                .collect(Collectors.toList());
    }

}