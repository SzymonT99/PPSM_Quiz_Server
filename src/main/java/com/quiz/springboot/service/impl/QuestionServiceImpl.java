package com.quiz.springboot.service.impl;

import com.quiz.springboot.domain.dto.CreateQuestionDto;
import com.quiz.springboot.domain.model.Question;
import com.quiz.springboot.repository.QuestionRepository;
import com.quiz.springboot.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Override
    public boolean addQuestion(CreateQuestionDto createQuestion) {

        if (createQuestion.getAnswerA() != null && createQuestion.getAnswerB() != null &&
                createQuestion.getAnswerC() != null && createQuestion.getAnswerD() != null &&
                createQuestion.getContent() != null && createQuestion.getCorrectAnswer() != null){

            Question addedQuestion = new Question(createQuestion.getContent(),createQuestion.getAnswerA(), createQuestion.getAnswerB(),
                    createQuestion.getAnswerC(), createQuestion.getAnswerD(), createQuestion.getCorrectAnswer(), false, 0);

            questionRepository.save(addedQuestion);
        }

        return false;
    }

    @Override
    public void specifyAvailability(Long id_question) {
        Question updatedQuestion = questionRepository.findById(id_question).orElse(null);
        if (updatedQuestion != null) {
            updatedQuestion.setAvailable(true);
        }

    }

    @Override
    public void specifyWeight(Long id_question, Integer point) {
        Question updatedQuestion = questionRepository.findById(id_question).orElse(null);
        if (updatedQuestion != null) {
            updatedQuestion.setPoints(point);
        }
    }
}
