package com.quiz.springboot.service.impl;

import com.quiz.springboot.domain.dto.CreateQuestionDto;
import com.quiz.springboot.domain.model.Question;
import com.quiz.springboot.domain.model.Statistics;
import com.quiz.springboot.domain.model.User;
import com.quiz.springboot.repository.QuestionRepository;
import com.quiz.springboot.repository.UserRepository;
import com.quiz.springboot.service.QuestionService;
import com.quiz.springboot.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private StatisticsService statisticsService;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Question> getQuestions() {
        return questionRepository.findByOrderByPointsAsc();         // pytania posortowane po liczbie punktów
    }

    @Override
    public Question getQuestionById(Long id) {
        return questionRepository.findById(id).orElse(null);
    }

    @Override
    public boolean addQuestion(CreateQuestionDto createQuestion) {

        if (createQuestion.getAnswerA() != null && createQuestion.getAnswerB() != null &&
                createQuestion.getAnswerC() != null && createQuestion.getAnswerD() != null &&
                createQuestion.getContent() != null && createQuestion.getCorrectAnswer() != null){

            if (userRepository.existsByLogin(createQuestion.getLogin())) {
                Question addedQuestion = new Question(createQuestion.getContent(), createQuestion.getAnswerA(), createQuestion.getAnswerB(),
                        createQuestion.getAnswerC(), createQuestion.getAnswerD(), createQuestion.getCorrectAnswer(), false, 0);
                questionRepository.save(addedQuestion);

                User user = userRepository.findByLogin(createQuestion.getLogin());
                Statistics statistics = user.getStats();
                statisticsService.updateAddedQuestions(statistics);       // dodano 1 do dodanych pytań
            }
            else{
                return false;
            }

        }
        return false;
    }

    @Override
    public void specifyAvailability(Long id_question) {
        Question updatedQuestion = questionRepository.findById(id_question).orElse(null);
        if (updatedQuestion != null) {
            updatedQuestion.setAvailable(true);
            questionRepository.save(updatedQuestion);
        }

    }

    @Override
    public void specifyWeight(Long id_question, Integer point) {
        Question updatedQuestion = questionRepository.findById(id_question).orElse(null);
        if (updatedQuestion != null) {
            updatedQuestion.setPoints(point);
            questionRepository.save(updatedQuestion);
        }
    }

    @Override
    public void deleteQuestion(Long id_question) {
        questionRepository.deleteById(id_question);
    }
}
