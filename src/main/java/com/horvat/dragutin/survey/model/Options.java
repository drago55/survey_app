package com.horvat.dragutin.survey.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Options extends BaseEntity{

    private String text;
    @ManyToMany
    @JoinTable(
            name = "Options_OptionsGroup",
            joinColumns = { @JoinColumn(name = "option_id") },
            inverseJoinColumns = { @JoinColumn(name = "option_group_id") }
    )
    private Set<OptionGroup> optionGroup;
    @ManyToOne
    @JoinColumn(name="question_id", insertable = false, updatable = false)
    private Question question;

    public Options(){}

    public Options(String text){
        this.text = text;
        this.optionGroup = new HashSet<>();
    }

    public Options(String text, Set<OptionGroup> optionGroup){
        this.text = text;
        this.optionGroup = optionGroup;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Options(Set<OptionGroup> optionGroup){
        this.optionGroup = optionGroup;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Set<OptionGroup> getOptionGroup() {
        return optionGroup;
    }

    public void setOptionGroup(Set<OptionGroup> optionGroup) {
        this.optionGroup = optionGroup;
    }

    @Override
    public String toString() {
        return "OptionsChoice{" +
                "text='" + text + '\'' +
                ", optionGroup=" + optionGroup +
                '}';
    }
}
