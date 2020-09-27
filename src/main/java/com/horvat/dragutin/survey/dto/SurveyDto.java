package com.horvat.dragutin.survey.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class SurveyDto implements Serializable {

    private List<QuestionDto> questions;
    private LocalDateTime created;
    private String name;

    public List<QuestionDto> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDto> questions) {
        this.questions = questions;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SurveyDto{" +
                "questions=" + questions +
                ", created=" + created +
                ", name='" + name + '\'' +
                '}';
    }
}
