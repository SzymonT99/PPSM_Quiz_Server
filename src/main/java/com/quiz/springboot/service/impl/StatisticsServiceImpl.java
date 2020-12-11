package com.quiz.springboot.service.impl;

import com.quiz.springboot.domain.model.Result;
import com.quiz.springboot.domain.model.Statistics;
import com.quiz.springboot.repository.StatisticsRepository;
import com.quiz.springboot.service.ResultService;
import com.quiz.springboot.service.StatisticsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private StatisticsRepository statisticsRepository;

    @Autowired
    private ResultService resultService;


    @Override
    public void updateAddedQuestions(Statistics statistics) {
        statistics.setAddedQuestions(statistics.getAddedQuestions() + 1);
        statisticsRepository.save(statistics);
    }

    @Override
    public void updateNumberCorrectQuestions(Statistics statistics, Integer correct) {
        statistics.setCorrectAnswer(statistics.getCorrectAnswer() + correct);
        statisticsRepository.save(statistics);
    }

    @Override
    public void updateNumberIncorrectQuestions(Statistics statistics, Integer incorrect) {
        statistics.setIncorrectAnswer(statistics.getIncorrectAnswer() + incorrect);
        statisticsRepository.save(statistics);
    }

    @Override
    public void updateUserRanking(Statistics statistics, String login) {
       List<Result> ranking =  resultService.getBestResultUsers();
       for (int i = 0; i < ranking.size(); i++){
           if (ranking.get(i).getUser().getLogin().equals(login)){
               statistics.setCurrentRank(i + 1);
           }
       }
    }
}
