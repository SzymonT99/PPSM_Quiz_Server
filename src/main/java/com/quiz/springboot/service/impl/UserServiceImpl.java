package com.quiz.springboot.service.impl;

import com.quiz.springboot.domain.dto.*;
import com.quiz.springboot.domain.model.AuthorizationStatus;
import com.quiz.springboot.domain.model.Roles;
import com.quiz.springboot.domain.model.Statistics;
import com.quiz.springboot.domain.model.User;
import com.quiz.springboot.repository.StatisticsRepository;
import com.quiz.springboot.repository.UserRepository;
import com.quiz.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private Integer MAX_LOGIN_ATTEMPTS = 5;

    @Autowired
    UserRepository userRepository;

    @Autowired
    StatisticsRepository statisticsRepository;

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User getUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public boolean registerUser(CreateUserDto createUser) {

        if (createUser.getLogin() != null && createUser.getEmail() != null && createUser.getPassword() != null) {

            Statistics initStatistics = new Statistics(0, 0, 0, 0, 0);
            statisticsRepository.save(initStatistics);

            User user = new User(initStatistics, createUser.getLogin(), createUser.getEmail(), createUser.getPassword(),
                    Roles.ROLE_USER, true, 0);

            userRepository.save(user);

            return true;
        }

        return false;
    }


    @Override
    public AuthorizationStatus checkLogin(UserVerificationDto userVerification) {

        if (!userRepository.existsByLogin(userVerification.getLogin())) {

            if (!userVerification.getPassword().equals(userVerification.getRepeatedPassword())) {
                return AuthorizationStatus.UNAUTHORIZED;
            }

            User user = userRepository.findByLogin(userVerification.getLogin());

            if (!user.getActive()) {
                return AuthorizationStatus.FORBIDDEN;
            }

            if (!user.getPassword().equals(userVerification.getPassword())) {

                user.setIncorrectLoginCounter(user.getIncorrectLoginCounter() + 1);
                user.setActive(user.getIncorrectLoginCounter() < MAX_LOGIN_ATTEMPTS);
                userRepository.save(user);

                return AuthorizationStatus.UNAUTHORIZED;
            }

            if (user.getPassword().equals(userVerification.getPassword()) && user.getIncorrectLoginCounter() < MAX_LOGIN_ATTEMPTS) {
                user.setIncorrectLoginCounter(0);
                userRepository.save(user);

                return AuthorizationStatus.ACCESS;
            }
        }

        return AuthorizationStatus.UNAUTHORIZED;
    }


    @Override
    public void updateUserLogin(ChangedUserLoginDto changedUserLogin) {

        User user = userRepository.findByLogin(changedUserLogin.getOldLogin());
        user.setLogin(changedUserLogin.getNewLogin());

        userRepository.save(user);
    }

    @Override
    public boolean updateUserPassword(ChangedUserPasswordDto changedUserPassword) {

        User user = userRepository.findByLogin(changedUserPassword.getLogin());

        if (!user.getPassword().equals(changedUserPassword.getOldPassword())){
            return false;
        }
        else {

            user.setPassword(changedUserPassword.getNewPassword());
            userRepository.save(user);
            return true;
        }
    }

    @Override
    public boolean deleteUser(DeleteUserDto deleteUser) {

        User user = userRepository.findByLogin(deleteUser.getLogin());

        if (!user.getPassword().equals(deleteUser.getPassword())){

            return false;
        }
        else {

            userRepository.deleteByLogin(deleteUser.getLogin());
            return true;

        }
    }
}
