package com.quiz.springboot.domain.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stats_id")
    private Statistics stats;

    @NotEmpty
    private String login;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String password;

    @Enumerated(EnumType.STRING)
    private Roles role;

    @NotEmpty
    private Boolean active;

    private Integer incorrectLoginCounter;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Result> games;

    public User() {
    }

    public User(Statistics stats, @NotEmpty @Size(min = 4, max = 20) String login,
                @NotEmpty @Email String email, @NotEmpty @Size(min = 10, max = 50) String password,
                Roles role, @NotEmpty Boolean active, Integer incorrectLoginCounter) {
        this.stats = stats;
        this.login = login;
        this.email = email;
        this.password = password;
        this.role = role;
        this.active = active;
        this.incorrectLoginCounter = incorrectLoginCounter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Statistics getStats() {
        return stats;
    }

    public void setStats(Statistics stats) {
        this.stats = stats;
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

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getIncorrectLoginCounter() {
        return incorrectLoginCounter;
    }

    public void setIncorrectLoginCounter(Integer incorrectLoginCounter) {
        this.incorrectLoginCounter = incorrectLoginCounter;
    }

    public Set<Result> getGames() {
        return games;
    }

    public void setGames(Set<Result> games) {
        this.games = games;
    }
}