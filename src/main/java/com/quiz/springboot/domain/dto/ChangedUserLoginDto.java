package com.quiz.springboot.domain.dto;

public class ChangedUserLoginDto {

    private String oldLogin;
    private String newLogin;

    public ChangedUserLoginDto() {
    }

    public ChangedUserLoginDto(String oldLogin, String newLogin) {
        this.oldLogin = oldLogin;
        this.newLogin = newLogin;
    }

    public String getOldLogin() {
        return oldLogin;
    }

    public void setOldLogin(String oldLogin) {
        this.oldLogin = oldLogin;
    }

    public String getNewLogin() {
        return newLogin;
    }

    public void setNewLogin(String newLogin) {
        this.newLogin = newLogin;
    }
}
