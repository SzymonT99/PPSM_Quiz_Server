package com.quiz.springboot.service;

import com.quiz.springboot.domain.model.Statistics;

import java.util.List;

public interface StatisticsService {

    void updateAddedQuestions(Statistics statistics);

    void updateNumberCorrectQuestions(Statistics statistics, Integer correct);

    void updateNumberIncorrectQuestions(Statistics statistics, Integer incorrect);

    void updateNumberGames(Statistics statistics);

    Statistics getUserStatistics(String nick);

    List<Statistics> getStatistics();

    void updateRanking();
}
