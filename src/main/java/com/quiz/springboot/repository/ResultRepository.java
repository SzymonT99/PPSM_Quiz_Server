package com.quiz.springboot.repository;

import com.quiz.springboot.domain.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends JpaRepository <Result, Long> {
}
