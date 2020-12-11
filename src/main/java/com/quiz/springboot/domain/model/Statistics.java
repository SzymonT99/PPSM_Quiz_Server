package com.quiz.springboot.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "statistics")
public class Statistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name="games_number")
    private Integer gamesNumber;

    @NotNull
    @Column(name="correct_answer")
    private Integer correctAnswer;

    @NotNull
    @Column(name="incorrect_answer")
    private Integer incorrectAnswer;

    @NotNull
    @Column(name="added_questions")
    private Integer addedQuestions;

    @NotNull
    @Column(name="current_rank")
    private Integer currentRank;

    @NotNull
    @OneToOne(mappedBy = "stats", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private User user;

    public Statistics() {
    }

    public Statistics(@NotNull Integer gamesNumber, @NotNull Integer correctAnswer, @NotNull Integer incorrectAnswer, @NotNull Integer addedQuestions, @NotNull Integer currentRank) {
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
