package com.ms.user.controller;

import com.ms.user.dto.UserDto;
import com.ms.user.model.User;
import com.ms.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody @Valid UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }
}
