package com.quiz.springboot.domain.dto;

import java.util.Date;

public class UserResultDto {

    private String Login;
    private Integer points;
    private Date date;

    public UserResultDto() {
    }

    public UserResultDto(String login, Integer points, Date date) {
        Login = login;
        this.points = points;
        this.date = date;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
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
}
