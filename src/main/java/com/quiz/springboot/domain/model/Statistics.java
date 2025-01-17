package com.quiz.springboot.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "statistics")
public class Statistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "games_number")
    private Integer gamesNumber;

    @Column(name = "correct_answer")
    private Integer correctAnswer;

    @Column(name = "incorrect_answer")
    private Integer incorrectAnswer;

    @Column(name = "added_questions")
    private Integer addedQuestions;

    @Column(name = "current_rank")
    private Integer currentRank;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    public Statistics() {
    }

    public Statistics(Integer gamesNumber, Integer correctAnswer, Integer incorrectAnswer, Integer addedQuestions, Integer currentRank) {
        this.gamesNumber = gamesNumber;
        this.correctAnswer = correctAnswer;
        this.incorrectAnswer = incorrectAnswer;
        this.addedQuestions = addedQuestions;
        this.currentRank = currentRank;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getGamesNumber() {
        return gamesNumber;
    }

    public void setGamesNumber(Integer gamesNumber) {
        this.gamesNumber = gamesNumber;
    }

    public Integer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Integer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Integer getIncorrectAnswer() {
        return incorrectAnswer;
    }

    public void setIncorrectAnswer(Integer incorrectAnswer) {
        this.incorrectAnswer = incorrectAnswer;
    }

    public Integer getAddedQuestions() {
        return addedQuestions;
    }

    public void setAddedQuestions(Integer addedQuestions) {
        this.addedQuestions = addedQuestions;
    }

    public Integer getCurrentRank() {
        return currentRank;
    }

    public void setCurrentRank(Integer currentRank) {
        this.currentRank = currentRank;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
