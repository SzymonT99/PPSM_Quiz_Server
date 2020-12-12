package com.quiz.springboot.domain.dto;

public class SpecifyQuestionDto {

    private String category;
    private Integer points;

    public SpecifyQuestionDto() {
    }

    public SpecifyQuestionDto(String category, Integer points) {
        this.category = category;
        this.points = points;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "SpecifyQuestionDto{" +
                "category='" + category + '\'' +
                ", points=" + points +
                '}';
    }
}
