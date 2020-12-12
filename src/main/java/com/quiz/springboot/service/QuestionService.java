package com.quiz.springboot.service;

import com.quiz.springboot.domain.dto.CreateQuestionDto;
import com.quiz.springboot.domain.model.Question;

import java.util.List;

public interface QuestionService {

    List<Question> getQuestions();

    Question getQuestionById(Long id);

    boolean addQuestion(CreateQuestionDto createQuestion);

    void specifyAvailability(Long id_question);

    void specifyWeight(Long id_question, Integer point);

    void deleteQuestion(Long id_question);
}
