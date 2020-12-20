package com.quiz.springboot.service.impl;

import com.quiz.springboot.domain.dto.CreateQuestionDto;
import com.quiz.springboot.domain.dto.SpecifyQuestionDto;
import com.quiz.springboot.domain.model.Answer;
import com.quiz.springboot.domain.model.Question;
import com.quiz.springboot.domain.model.Statistics;
import com.quiz.springboot.domain.model.User;
import com.quiz.springboot.repository.AnswerRepository;
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

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public List<Question> getQuestions(boolean active) {
        return questionRepository.findByAvailableOrderByPointsAsc(active);         // aktywne pytania posortowane po liczbie punktów
    }

    @Override
    public Question getQuestionById(Long id) {
        return questionRepository.findById(id).orElse(null);
    }

    @Override
    public boolean addQuestion(CreateQuestionDto createQuestion) {

        if (createQuestion.getAnswerA() != null && createQuestion.getAnswerB() != null &&
                createQuestion.getAnswerC() != null && createQuestion.getAnswerD() != null &&
                createQuestion.getContent() != null && createQuestion.getSeconds() != null &&
                createQuestion.getCorrectAnswer() != null){

            if (userRepository.existsByLogin(createQuestion.getLogin())) {

                Question addedQuestion = new Question(createQuestion.getContent(), null, createQuestion.getSeconds(), false, 0);
                questionRepository.save(addedQuestion);

                Answer answer1 = new Answer(createQuestion.getAnswerA(), false, addedQuestion);
                Answer answer2 = new Answer(createQuestion.getAnswerB(), false, addedQuestion);
                Answer answer3 = new Answer(createQuestion.getAnswerC(), false, addedQuestion);
                Answer answer4 = new Answer(createQuestion.getAnswerD(), false, addedQuestion);

                if (createQuestion.getCorrectAnswer() == 1){
                    answer1.setCorrect(true);
                }
                else if (createQuestion.getCorrectAnswer() == 2) {
                    answer2.setCorrect(true);
                }
                else if (createQuestion.getCorrectAnswer() == 3) {
                    answer3.setCorrect(true);
                }
                else {
                    answer4.setCorrect(true);
                }

                answerRepository.save(answer1);
                answerRepository.save(answer2);
                answerRepository.save(answer3);
                answerRepository.save(answer4);

                User user = userRepository.findByLogin(createQuestion.getLogin());
                Statistics statistics = user.getStats();
                statisticsService.updateAddedQuestions(statistics);       // dodano 1 do dodanych pytań

                return true;
            }
            else{
                System.out.println("tu1");
                return false;
            }

        }
        System.out.println("tu2");
        return false;
    }

    @Override
    public boolean specifyQuestion(Long id_question, SpecifyQuestionDto specifyQuestionDto) {

        if (specifyQuestionDto.getCategory() != null && specifyQuestionDto.getPoints() != null){

            Question updatedQuestion = questionRepository.findById(id_question).orElse(null);
            if (updatedQuestion != null) {
                updatedQuestion.setAvailable(true);
                updatedQuestion.setCategory(specifyQuestionDto.getCategory());
                updatedQuestion.setPoints(specifyQuestionDto.getPoints());
                questionRepository.save(updatedQuestion);
            }
            else {
                return false;
            }

        }
        return false;
    }


    @Override
    public void deleteQuestion(Long id_question) {
        questionRepository.deleteById(id_question);
    }
}
