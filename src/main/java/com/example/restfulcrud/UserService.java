package com.example.restfulcrud;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Long save(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setAge(userDTO.getAge());
        userRepository.save(user);
        return user.getId();
    }

    public Long update(Long id, UserDTO userDTO) {
        User updateUser = userRepository.findById(id);
        updateUser.setName(userDTO.getName());
        updateUser.setAge(userDTO.getAge());
        return updateUser.getId();
    }

    public void remove(Long id) {
        userRepository.remove(id);
    }

    public UserDTO findById(Long id) {
        User user = userRepository.findById(id);
        if (user == null) {
            throw new IllegalArgumentException("ID에 해당하는 유저를 찾을 수 없습니다.");
        }
        return convertToDTO(user);
    }

    public UserDTO findByName(String name) {
        User user = userRepository.findByName(name);
        if (user == null) {
            throw new IllegalArgumentException("이름에 해당하는 유저를 찾을 수 없습니다.");
        }
        return convertToDTO(user);
    }

    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();
        return convertToDTOList(users);
    }

    private UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setAge(user.getAge());
        return userDTO;
    }

    private List<UserDTO> convertToDTOList(List<User> users) {
        return users.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
