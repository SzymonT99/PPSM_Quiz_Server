package com.quiz.springboot.repository;

import com.quiz.springboot.domain.model.Rates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RatesRepository extends JpaRepository<Rates, Long> {

    @Query("SELECT COUNT(r) FROM Rates r WHERE r.positiveOpinion = true")
    int getGoodRates();

    @Query("SELECT COUNT(r) FROM Rates r WHERE r.positiveOpinion = false")
    int getBadRates();

    boolean existsByUserName(String userName);

    Rates findByUserName(String userName);
}

