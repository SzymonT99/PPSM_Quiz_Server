package com.quiz.springboot.rest;


import com.quiz.springboot.domain.dto.*;
import com.quiz.springboot.domain.model.AuthorizationStatus;
import com.quiz.springboot.domain.model.Roles;
import com.quiz.springboot.domain.model.User;
import com.quiz.springboot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/quiz")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/create-user")
    public ResponseEntity<Void> createUser(@Valid @RequestBody CreateUserDto createUserDto){

        LOGGER.info("--- login: {}", createUserDto.getLogin());
        LOGGER.info("--- e-mail: {}", createUserDto.getEmail());
        //LOGGER.info("--- password: {}", createUserDto.getPassword());

        HttpStatus code =  userService.registerUser(createUserDto);

        return new ResponseEntity<>(code);
    }

    @PostMapping("/user/login")
    public ResponseEntity<?> authorizeUser(@RequestBody UserAutorizationDto userVerificationDto) {

        LOGGER.info("--- check login data: {}", userVerificationDto.getLogin());

        AuthorizationStatus status = userService.checkLogin(userVerificationDto);

        Roles role = userService.checkRole(userVerificationDto.getLogin());

        if (status == AuthorizationStatus.ACCESS) {
            return new ResponseEntity<>(role ,HttpStatus.OK);
        } else if (status == AuthorizationStatus.UNAUTHORIZED) {
            return new ResponseEntity<>(role, HttpStatus.UNAUTHORIZED);
        } else {
            return new ResponseEntity<>(role, HttpStatus.FORBIDDEN);
        }

    }

    @PutMapping("/user-update/login")
    public ResponseEntity<Void> updateLogin(@Valid @RequestBody ChangedUserLoginDto changedUserLoginDto) {

        LOGGER.info("--- old login: {}", changedUserLoginDto.getOldLogin());
        LOGGER.info("--- new login: {}", changedUserLoginDto.getNewLogin());

        boolean status = userService.updateUserLogin(changedUserLoginDto);

        return status
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @PutMapping("/user-update/password")
    public ResponseEntity<Void> updatePassword(@Valid @RequestBody ChangedUserPasswordDto changedUserLoginDto) {

        LOGGER.info("--- login: {}", changedUserLoginDto.getLogin());

        boolean status = userService.updateUserPassword(changedUserLoginDto);

        return status
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @DeleteMapping("/delete-user")
    public ResponseEntity<Void> deleteUser(@RequestBody DeleteUserDto deleteUserDto) {

        boolean deletedStatus = userService.deleteUser(deleteUserDto);

        return deletedStatus
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {

        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

}

