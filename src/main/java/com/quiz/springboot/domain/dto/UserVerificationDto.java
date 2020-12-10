package com.quiz.springboot.domain.dto;

public class UserVerificationDto {

    private String login;
    private String password;
    private String repeatedPassword;

    public UserVerificationDto() {
    }

    public UserVerificationDto(String login, String password, String repeatedPassword) {
        this.login = login;
        this.password = password;
        this.repeatedPassword = repeatedPassword;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatedPassword() {
        return repeatedPassword;
    }

    public void setRepeatedPassword(String repeatedPassword) {
        this.repeatedPassword = repeatedPassword;
    }
}
