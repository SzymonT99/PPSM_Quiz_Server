package com.quiz.springboot.service;

import com.quiz.springboot.domain.dto.*;
import com.quiz.springboot.domain.model.AuthorizationStatus;
import com.quiz.springboot.domain.model.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    User getUserByLogin(String login);

    boolean registerUser(CreateUserDto createUser);

    AuthorizationStatus checkLogin(UserVerificationDto userVerification);

    boolean updateUserLogin(ChangedUserLoginDto changedUserLogin);

    boolean updateUserPassword(ChangedUserPasswordDto changedUserPassword);

    boolean deleteUser (DeleteUserDto deleteUser);
}
