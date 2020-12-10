package com.quiz.springboot.domain.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class CreateUserDto {

    @Size(min = 4, max = 20)
    private String login;

    @Email
    private String email;

    @Size(min = 10, max = 50)
    private String password;

    public CreateUserDto() {
    }

    public CreateUserDto(String login, String email, String password) {
        this.login = login;
        this.email = email;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
