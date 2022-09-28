package org.SpringDemo.demo.service;

import lombok.AllArgsConstructor;
import org.SpringDemo.demo.dto.request.SignupRequest;
import org.SpringDemo.demo.dto.response.UserDTO;
import org.SpringDemo.demo.exception.ElementNotFoundException;
import org.SpringDemo.demo.model.User;
import org.SpringDemo.demo.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public UserDTO postNewUser(SignupRequest signupRequest) {
        User user = User.builder()
                .username(signupRequest.getUsername())
                .password(signupRequest.getPassword())
                .email(signupRequest.getEmail())
                .build();

        userRepository.save(user);
        return mapToDTO(user);
    }

    public UserDTO updateUser(String id, SignupRequest signupRequest) {
        User user = getUserById(id);

        user.setUsername(signupRequest.getUsername());
        user.setPassword(signupRequest.getPassword());
        user.setEmail(signupRequest.getEmail());

        userRepository.save(user);
        return mapToDTO(user);
    }

    public UserDTO getUserDTOById(String id) {
        return mapToDTO(getUserById(id));
    }

    public void deleteUser(String id) {
        User user = getUserById(id);
        userRepository.delete(user);
    }

    private User getUserById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException("User amb id: " + id + " no trobat."));
    }

    //ModelMapper a DTO
    private UserDTO mapToDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }
}