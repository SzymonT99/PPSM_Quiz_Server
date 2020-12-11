package com.quiz.springboot.service;

import com.quiz.springboot.domain.dto.UserResultDto;
import com.quiz.springboot.domain.model.Result;

import java.util.List;

public interface ResultService {

    List<Result> getResults();

    List<Result> getBestResultUsers();

    void saveCurrentResult(UserResultDto userResult);

    void deleteResult(Long id);

}
