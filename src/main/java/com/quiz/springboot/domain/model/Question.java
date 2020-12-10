package com.quiz.springboot.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String content;

    @NotEmpty
    @Column(name = "answer_a")
    private String answerA;

    @NotEmpty
    @Column(name = "answer_b")
    private String answerB;

    @NotEmpty
    @Column(name = "answer_c")
    private String answerC;

    @NotEmpty
    @Column(name = "answer_d")
    private String answerD;

    @NotEmpty
    @Column(name = "correct_answer")
    private Integer correctAnswer;

    @NotEmpty
    private Boolean available;

    @NotEmpty
    private Integer points;


    public Question() {
    }

    public Question(Long id, @NotEmpty String content, @NotEmpty String answerA, @NotEmpty String answerB,
                    @NotEmpty String answerC, @NotEmpty String answerD, @NotEmpty Integer correctAnswer,
                    @NotEmpty Boolean available, @NotEmpty Integer points) {
        this.id = id;
        this.content = content;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.correctAnswer = correctAnswer;
        this.available = available;
        this.points = points;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    public Integer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Integer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", answerA='" + answerA + '\'' +
                ", answerB='" + answerB + '\'' +
                ", answerC='" + answerC + '\'' +
                ", answerD='" + answerD + '\'' +
                ", correctAnswer=" + correctAnswer +
                ", available=" + available +
                ", points=" + points +
                '}';
    }
}