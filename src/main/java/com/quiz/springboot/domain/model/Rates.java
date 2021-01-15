package com.quiz.springboot.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "rates")
public class Rates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "positive_opinion")
    private boolean positiveOpinion;

    @Column(name = "user_name")
    private String userName;

    public Rates() {
    }

    public Rates(@NotNull boolean positiveOpinion, String userName) {
        this.positiveOpinion = positiveOpinion;
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isPositiveOpinion() {
        return positiveOpinion;
    }

    public void setPositiveOpinion(boolean positiveOpinion) {
        this.positiveOpinion = positiveOpinion;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
