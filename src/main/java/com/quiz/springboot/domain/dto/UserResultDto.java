package com.quiz.springboot.domain.dto;

import java.util.Date;

public class UserResultDto {

    private Integer points;
    private Date date;

    public UserResultDto() {
    }

    public UserResultDto(Integer points, Date date) {
        this.points = points;
        this.date = date;
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
