package com.quiz.springboot.service;

import com.quiz.springboot.domain.dto.CreateQuestionDto;

public interface QuestionService {

    boolean addQuestion(CreateQuestionDto createQuestion);

    void specifyAvailability(Long id_question);

    void specifyWeight(Long id_question, Integer point);
}
