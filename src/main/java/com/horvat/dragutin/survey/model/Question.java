package com.horvat.dragutin.survey.model;

import com.horvat.dragutin.survey.enums.QuestionType;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Question extends BaseEntity {

    private String text;

    @OneToMany
    @JoinColumn(name = "question_id")
    private Set<Options> options;

    @Enumerated(EnumType.STRING)
    private QuestionType questionType;

    private Boolean allowMultipleOptions;

    @OneToOne
    private InputType inputType;

    @ManyToMany(mappedBy = "questions")
    private Set<Survey> surveys;

    public Question(){}

    public Set<Survey> getSurveys() {
        return surveys;
    }

    public void setSurveys(Set<Survey> surveys) {
        this.surveys = surveys;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Set<Options> getOptions() {
        return options;
    }

    public void setOptions(Set<Options> options) {
        this.options = options;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public InputType getInputType() {
        return inputType;
    }

    public void setInputType(InputType inputType) {
        this.inputType = inputType;
    }

    public Boolean getAllowMultipleOptions() {
        return allowMultipleOptions;
    }

    public void setAllowMultipleOptions(Boolean allowMultipleOptions) {
        this.allowMultipleOptions = allowMultipleOptions;
    }

    @Override
    public String toString() {
        return "Question{" +
                "text='" + text + '\'' +
                ", options=" + options +
                ", questionType=" + questionType +
                ", allowMultipleOptions=" + allowMultipleOptions +
                ", inputType=" + inputType +
                '}';
    }

}
