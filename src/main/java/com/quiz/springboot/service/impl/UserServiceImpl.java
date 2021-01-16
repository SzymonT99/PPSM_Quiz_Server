package com.quiz.springboot.service.impl;

import com.quiz.springboot.domain.dto.*;
import com.quiz.springboot.domain.model.*;
import com.quiz.springboot.repository.QuestionRepository;
import com.quiz.springboot.repository.RatesRepository;
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
    private UserRepository userRepository;

    @Autowired
    private StatisticsRepository statisticsRepository;

    @Autowired
    private RatesRepository ratesRepository;

    @Autowired
    private QuestionRepository questionRepository;

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

        User user = userRepository.findByLogin(changedUserLogin.getOldLogin());

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        if (!bCryptPasswordEncoder.matches(changedUserLogin.getPassword(), user.getPassword())) {
            return false;
        }
        else {

            user.setLogin(changedUserLogin.getNewLogin());
            userRepository.save(user);

            if (ratesRepository.existsByUserName(changedUserLogin.getOldLogin())){
                Rates rates = ratesRepository.findByUserName(changedUserLogin.getOldLogin());
                rates.setUserName(changedUserLogin.getNewLogin());                      // aktualizacja loga w ocenach aplikacji
                ratesRepository.save(rates);
            }

            if (questionRepository.existsByAuthor(changedUserLogin.getOldLogin())){
                List<Question> authorQuestions = questionRepository.findAllByAuthor(changedUserLogin.getOldLogin());
                for (Question question : authorQuestions) {
                    question.setAuthor(changedUserLogin.getNewLogin());                 // akualizacja nazwy gracza przy dodanych pytaniach
                    questionRepository.save(question);
                }
            }

            return true;
        }

    }

    @Override
    public boolean updateUserPassword(ChangedUserPasswordDto changedUserPassword) {

        User user = userRepository.findByLogin(changedUserPassword.getLogin());

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        if (!bCryptPasswordEncoder.matches(changedUserPassword.getOldPassword(), user.getPassword())) {
            return false;
        } else {

            user.setPassword(bCryptPasswordEncoder.encode(changedUserPassword.getNewPassword()));
            userRepository.save(user);
            return true;
        }
    }

    @Override
    @Transactional
    public boolean deleteUser(DeleteUserDto deleteUser) {

        User user = userRepository.findByLogin(deleteUser.getLogin());

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        if (!bCryptPasswordEncoder.matches(deleteUser.getPassword(), user.getPassword())) {
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
