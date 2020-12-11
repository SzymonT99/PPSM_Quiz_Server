package com.quiz.springboot.service;

import com.quiz.springboot.domain.model.Statistics;

public interface StatisticsService {

    void updateAddedQuestions(Statistics statistics);

    void updateNumberCorrectQuestions(Statistics statistics, Integer correct);

    void updateNumberIncorrectQuestions(Statistics statistics, Integer incorrect);

    void updateUserRanking(Statistics statistics, String login);
}
