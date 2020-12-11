package com.quiz.springboot.repository;

import com.quiz.springboot.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {

    User findByLogin(String login);
    boolean existsByLogin(String login);
    void deleteByLogin(String login);
}
