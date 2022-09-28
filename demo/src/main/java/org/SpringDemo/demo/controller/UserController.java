package org.SpringDemo.demo.controller;

import lombok.AllArgsConstructor;
import org.SpringDemo.demo.dto.request.SignupRequest;
import org.SpringDemo.demo.dto.response.UserDTO;
import org.SpringDemo.demo.model.User;
import org.SpringDemo.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> getAll() {
        List<UserDTO> users = userService.getAllUsers();
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<UserDTO> newUser(@Valid @RequestBody SignupRequest signupRequest) {
        return new ResponseEntity<>(userService.postNewUser(signupRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody SignupRequest signupRequest, @PathVariable("id") String id) {
        return new ResponseEntity<>(userService.updateUser(id, signupRequest), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable("id") String id) {
        return new ResponseEntity<>(userService.getUserDTOById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") String id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}