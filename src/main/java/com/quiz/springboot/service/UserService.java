package com.quiz.springboot.service;

import com.quiz.springboot.domain.dto.*;
import com.quiz.springboot.domain.model.AuthorizationStatus;
import com.quiz.springboot.domain.model.User;

import java.util.Optional;

public interface UserService {

    User getUserById(Long id);

    User getUserByLogin(String login);

    boolean registerUser(CreateUserDto createUser);

    AuthorizationStatus checkLogin(UserVerificationDto userVerification);

    void updateUserLogin(ChangedUserLoginDto changedUserLogin);

    boolean updateUserPassword(ChangedUserPasswordDto changedUserPassword);

    boolean deleteUser (DeleteUserDto deleteUser);
}
