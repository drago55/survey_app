package com.horvat.dragutin.survey.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Answer extends BaseEntity {

    @OneToOne
    private Question question;
    @OneToOne
    private Options optionChoice;
    @OneToOne
    private Survey survey;
    @OneToOne
    private User user;

    @OneToOne
    private OptionGroup optionGroup;

    public Answer(){}

    public OptionGroup getOptionGroup() {
        return optionGroup;
    }

    public void setOptionGroup(OptionGroup optionGroup) {
        this.optionGroup = optionGroup;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }


    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Options getOptionChoice() {
        return optionChoice;
    }

    public void setOptionChoice(Options optionChoice) {
        this.optionChoice = optionChoice;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "question=" + question.getText() +
                ", option=" +  optionChoice+
                ", survey=" + survey.getId() +
                ", user=" + user.getFirstName() +
                '}';
    }
}
