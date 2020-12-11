package com.quiz.springboot.domain.dto;

import java.util.Date;

public class UserResultDto {

    private String login;
    private Integer points;
    private Date date;
    private Integer correctAnswer;
    private Integer incorrectAnswer;

    public UserResultDto() {
    }

    public UserResultDto(String login, Integer points, Date date, Integer correctAnswer, Integer incorrectAnswer) {
        this.login = login;
        this.points = points;
        this.date = date;
        this.correctAnswer = correctAnswer;
        this.incorrectAnswer = incorrectAnswer;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
}
