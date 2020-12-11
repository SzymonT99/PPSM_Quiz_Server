package com.quiz.springboot.repository;

import com.quiz.springboot.domain.model.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticsRepository extends JpaRepository <Statistics, Long> {
}
