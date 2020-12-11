package com.quiz.springboot.service.impl;

import com.quiz.springboot.domain.dto.UserResultDto;
import com.quiz.springboot.domain.model.Result;
import com.quiz.springboot.domain.model.User;
import com.quiz.springboot.repository.ResultRepository;
import com.quiz.springboot.repository.UserRepository;
import com.quiz.springboot.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {

    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Result> getBestResultUsers() {
        return null;
    }

    @Override
    public void saveCurrentResult(UserResultDto userResult) {

        User user = userRepository.findByLogin(userResult.getLogin());
        Result result = new Result(user, userResult.getPoints(), userResult.getDate());
        resultRepository.save(result);

    }

    @Override
    public void deleteResultById(Long id) {
        resultRepository.deleteById(id);
    }
}
