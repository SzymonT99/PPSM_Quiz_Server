package com.quiz.springboot.rest;


import com.quiz.springboot.domain.dto.UserResultDto;
import com.quiz.springboot.domain.model.Result;
import com.quiz.springboot.service.ResultService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class ResultController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private ResultService resultService;


    @GetMapping("/ranking")
    public ResponseEntity<List<Result>> getRanking() {

        return new ResponseEntity<>(resultService.getBestResultUsers(), HttpStatus.OK);
    }

    @GetMapping("/results")
    public ResponseEntity<List<Result>> getAllResults() {

        return new ResponseEntity<>(resultService.getResults(), HttpStatus.OK);
    }

    @PostMapping("/save-result")
    public ResponseEntity<Void> saveResult(@RequestBody UserResultDto userResultDto){

        LOGGER.info("---  user login: {}", userResultDto.getLogin());
        LOGGER.info("---  game date: {}", userResultDto.getDate());
        LOGGER.info("---  number of correct answers: {}", userResultDto.getCorrectAnswer());
        LOGGER.info("---  number of incorrect answers: {}", userResultDto.getIncorrectAnswer());

        resultService.saveCurrentResult(userResultDto);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}


