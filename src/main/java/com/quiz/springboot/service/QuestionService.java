package com.quiz.springboot.service;

import com.quiz.springboot.domain.dto.CreateQuestionDto;
import com.quiz.springboot.domain.dto.SpecifyQuestionDto;
import com.quiz.springboot.domain.model.Question;

import java.util.List;

public interface QuestionService {

    List<Question> getQuestions();

    Question getQuestionById(Long id);

    boolean addQuestion(CreateQuestionDto createQuestion);

    boolean specifyQuestion(Long id_question, SpecifyQuestionDto specifyQuestionDto);

    void deleteQuestion(Long id_question);
}
