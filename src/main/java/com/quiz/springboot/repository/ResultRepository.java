package com.quiz.springboot.repository;

import com.quiz.springboot.domain.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ResultRepository extends JpaRepository <Result, Long> {

//    @Query("SELECT new com.quiz.springboot.domain.model.Result(r.user, MAX(r.points) AS points, MAX(r.date) AS date)" +
//            "FROM Result r " +
//            "GROUP BY r.user")
//    List<Result> findBestResultUsers();

}
