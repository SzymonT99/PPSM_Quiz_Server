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
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private Integer MAX_LOGIN_ATTEMPTS = 5;

    @Autowired
    UserRepository userRepository;

    @Autowired
    StatisticsRepository statisticsRepository;

    @Override
    public List<User> getUsers() {

        return  userRepository.findAll();
    }

    @Override
    public User getUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public HttpStatus registerUser(CreateUserDto createUser){

        if (userRepository.existsByLogin(createUser.getLogin())){
            return HttpStatus.FORBIDDEN;
        }

        if (createUser.getLogin() != null && createUser.getEmail() != null && createUser.getPassword() != null) {

            Statistics initStatistics = new Statistics(0, 0, 0, 0, 0);

            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

            User user = new User(createUser.getLogin(), createUser.getEmail(), bCryptPasswordEncoder.encode(createUser.getPassword()),
                    Roles.ROLE_USER, true, 0);

            initStatistics.setUser(user);
            user.setStats(initStatistics);

            userRepository.save(user);

            return HttpStatus.CREATED;
        }

        return HttpStatus.BAD_REQUEST;
    }


    @Override
    public AuthorizationStatus checkLogin(UserAutorizationDto userVerification){

        if (userRepository.existsByLogin(userVerification.getLogin())) {

            User user = userRepository.findByLogin(userVerification.getLogin());

            if (!user.getActive()) {
                return AuthorizationStatus.FORBIDDEN;
            }

            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

            if (!bCryptPasswordEncoder.matches(userVerification.getPassword(), user.getPassword())) {

                user.setIncorrectLoginCounter(user.getIncorrectLoginCounter() + 1);
                user.setActive(user.getIncorrectLoginCounter() < MAX_LOGIN_ATTEMPTS);
                userRepository.save(user);

                return AuthorizationStatus.UNAUTHORIZED;
            }

            if (bCryptPasswordEncoder.matches(userVerification.getPassword(), user.getPassword()) && user.getIncorrectLoginCounter() < MAX_LOGIN_ATTEMPTS) {
                user.setIncorrectLoginCounter(0);
                userRepository.save(user);

                return AuthorizationStatus.ACCESS;
            }
        }

        return AuthorizationStatus.UNAUTHORIZED;
    }


    @Override
    public boolean updateUserLogin(ChangedUserLoginDto changedUserLogin) {

        if (changedUserLogin.getOldLogin() != null && changedUserLogin.getNewLogin() != null) {

            User user = userRepository.findByLogin(changedUserLogin.getOldLogin());
            user.setLogin(changedUserLogin.getNewLogin());

            userRepository.save(user);

            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateUserPassword(ChangedUserPasswordDto changedUserPassword) {

        User user = userRepository.findByLogin(changedUserPassword.getLogin());

        if (!user.getPassword().equals(changedUserPassword.getOldPassword())) {
            return false;
        } else {

            user.setPassword(changedUserPassword.getNewPassword());
            userRepository.save(user);
            return true;
        }
    }

    @Override
    @Transactional
    public boolean deleteUser(DeleteUserDto deleteUser) {

        User user = userRepository.findByLogin(deleteUser.getLogin());

        if (!user.getPassword().equals(deleteUser.getPassword())) {

            return false;
        } else {

            userRepository.deleteByLogin(deleteUser.getLogin());
            return true;

        }
    }

    @Override
    public Roles checkRole(String login) {
        if (login != null) {

            if (userRepository.existsByLogin(login)){
                User user = userRepository.findByLogin(login);
                return user.getRole();
            }
            else {
                return Roles.NONE;
            }

        }
        else{
            return Roles.NONE;
        }
    }
}
