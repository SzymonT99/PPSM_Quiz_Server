package com.quiz.springboot.service.impl;

import com.quiz.springboot.domain.dto.QuizResult;
import com.quiz.springboot.domain.dto.UserResultDto;
import com.quiz.springboot.domain.model.Result;
import com.quiz.springboot.domain.model.Statistics;
import com.quiz.springboot.domain.model.User;
import com.quiz.springboot.repository.ResultRepository;
import com.quiz.springboot.repository.UserRepository;
import com.quiz.springboot.service.ResultService;
import com.quiz.springboot.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ResultServiceImpl implements ResultService {

    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StatisticsService statisticsService;

    @Override
    public List<Result> getResults() {

        return resultRepository.findAll();
    }

    @Override
    public List<Result> getBestResultUsers() {

        List<Result> ranking = new ArrayList<>();
        List<Result> allResults = resultRepository.findAll();
        Map<String, List<Result>> userResults =
                allResults.stream().collect(Collectors.groupingBy(w -> w.getUser().getLogin()));

        for (String user : userResults.keySet()) {

            Result bestUserResult = userResults.get(user).get(0);
            for (Result result : userResults.get(user)) {

                if (result.getPoints() > bestUserResult.getPoints()) {
                    bestUserResult = result;
                }
            }
            ranking.add(bestUserResult);

        }

        return ranking
                .stream().sorted(Comparator.comparing(Result::getPoints).reversed()).collect(Collectors.toList());

    }

    @Override
    public List<QuizResult> getRanking() {


        List<Result> ranking = getBestResultUsers();

        List<QuizResult> rankingResponse = new ArrayList<>();

        for (Result res : ranking) {
            rankingResponse.add(new QuizResult(res.getUser().getLogin(), res.getPoints(), res.getDate()));
        }

        return rankingResponse;
    }

    @Override
    public void saveCurrentResult(UserResultDto userResult) {

        User user = userRepository.findByLogin(userResult.getLogin());
        Result result = new Result(user, userResult.getPoints(), new Date());
        resultRepository.save(result);

        Statistics statistics = user.getStats();
        statisticsService.updateNumberCorrectQuestions(statistics, userResult.getCorrectAnswer());
        statisticsService.updateNumberIncorrectQuestions(statistics, userResult.getIncorrectAnswer());
        statisticsService.updateNumberGames(statistics);
        statisticsService.updateRanking();

    }

    @Override
    public void deleteResult(Long id) {

        resultRepository.deleteById(id);

    }

}
