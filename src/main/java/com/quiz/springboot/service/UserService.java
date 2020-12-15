package com.quiz.springboot.service;

import com.quiz.springboot.domain.dto.*;
import com.quiz.springboot.domain.model.AuthorizationStatus;
import com.quiz.springboot.domain.model.Roles;
import com.quiz.springboot.domain.model.User;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    User getUserByLogin(String login);

    User getUserById(Long id);

    HttpStatus registerUser(CreateUserDto createUser);

    AuthorizationStatus checkLogin(UserAutorizationDto userVerification);

    boolean updateUserLogin(ChangedUserLoginDto changedUserLogin);

    boolean updateUserPassword(ChangedUserPasswordDto changedUserPassword);

    boolean deleteUser (DeleteUserDto deleteUser);

    Roles checkRole(String login);
}
