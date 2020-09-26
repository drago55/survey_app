package com.horvat.dragutin.survey.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Survey extends BaseEntity{

    @ManyToMany
    @JoinTable(
            name = "Survey_Questions",
            joinColumns = { @JoinColumn(name = "survey_id") },
            inverseJoinColumns = { @JoinColumn(name = "question_id") }
    )
    private Set<Question> questions;

    @OneToMany
    @JoinColumn(name="survey_id")
    private Set<User> user;

    private String name;

    private LocalDateTime created;

    public Survey(){}

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Survey{" +
                "questions=" + questions +
                ", name='" + name + '\'' +
                ", created=" + created +
                '}';
    }
}
