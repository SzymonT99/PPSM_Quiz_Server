package com.quiz.springboot.rest;

import com.quiz.springboot.domain.dto.*;
import com.quiz.springboot.domain.model.Question;
import com.quiz.springboot.service.QuestionService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuestionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private QuestionService questionService;


    @GetMapping("/questions")
    public ResponseEntity<List<Question>> getQuestions() {

        return new ResponseEntity<>(questionService.getQuestions(), HttpStatus.OK);
    }

    @PostMapping("/add-question")
    public ResponseEntity<Void> addQuestion(@Valid @RequestBody CreateQuestionDto createQuestionDto) {

        LOGGER.info("--- user: {}", createQuestionDto.getLogin());
        LOGGER.info("--- question: {}", createQuestionDto.getContent());
        LOGGER.info("--- answer A: {}", createQuestionDto.getAnswerA());
        LOGGER.info("--- answer B: {}", createQuestionDto.getAnswerB());
        LOGGER.info("--- answer C: {}", createQuestionDto.getAnswerC());
        LOGGER.info("--- answer D: {}", createQuestionDto.getAnswerD());
        LOGGER.info("--- correct answer: {}", createQuestionDto.getCorrectAnswer());

        return questionService.addQuestion(createQuestionDto)
                ? new ResponseEntity<>(HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/question-accepted")
    public ResponseEntity<Void> postQuestion(@RequestParam(value = "id", required = true) Long id_question,
                                             @RequestParam(value = "points", required = true) Integer points) {

        LOGGER.info("--- id question: {}", id_question);
        LOGGER.info("--- points: {}", points);

        questionService.specifyAvailability(id_question);
        questionService.specifyWeight(id_question, points);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete-question/{id}")
    public ResponseEntity<Question> deleteQuestion(@PathVariable("id") Long id_question){

        Question deletedQuestion = questionService.getQuestionById(id_question);
        questionService.deleteQuestion(id_question);

        return new ResponseEntity<>(deletedQuestion, HttpStatus.OK);
    }


}
