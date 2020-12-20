package com.quiz.springboot.repository;

import com.quiz.springboot.domain.model.Question;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findByAvailableOrderByPointsAsc(boolean state);

}
