package com.quiz.springboot.rest;

import com.quiz.springboot.domain.model.Statistics;

import com.quiz.springboot.service.StatisticsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/quiz")
public class StatisticsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private StatisticsService statisticsService;


    @GetMapping("/statistics")
    public ResponseEntity<List<Statistics>> getStatistics() {

        return new ResponseEntity<>(statisticsService.getStatistics(), HttpStatus.OK);
    }
    @GetMapping("/statistics/{id}")

    public ResponseEntity<?> getUserStatistics(@PathVariable("id") Long userId) {

        Statistics statistics = statisticsService.getUserStatistics(userId);
        return statistics != null
                ? new ResponseEntity<>(statistics, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}


