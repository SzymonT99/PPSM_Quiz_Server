package com.quiz.springboot.service.impl;

import com.quiz.springboot.domain.model.Result;
import com.quiz.springboot.domain.model.Statistics;
import com.quiz.springboot.domain.model.User;
import com.quiz.springboot.repository.StatisticsRepository;
import com.quiz.springboot.repository.UserRepository;
import com.quiz.springboot.service.ResultService;
import com.quiz.springboot.service.StatisticsService;

import com.quiz.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private StatisticsRepository statisticsRepository;

    @Autowired
    private ResultService resultService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;


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
    public void updateNumberGames(Statistics statistics) {
        statistics.setGamesNumber(statistics.getGamesNumber() + 1);
        statisticsRepository.save(statistics);
    }

    @Override
    public Statistics getUserStatistics(Long id) {

        if (userRepository.existsById(id)) {
            User user = userService.getUserById(id);
            Statistics statistics = user.getStats();
            return statistics;
        }
        else{
            return null;
        }
    }

    @Override
    public List<Statistics> getStatistics() {
        return statisticsRepository.findAll();
    }

    @Override
    public void updateRanking() {

        List<Result> ranking =  resultService.getBestResultUsers();
        for (int i = 0; i < ranking.size(); i++){

            for (Statistics statistics : statisticsRepository.findAll()){

                if (ranking.get(i).getUser() == statistics.getUser()){
                    statistics.setCurrentRank(i + 1);
                    statisticsRepository.save(statistics);
                }

            }
        }

    }
}
