package com.horvat.dragutin.survey.dto;

import com.horvat.dragutin.survey.enums.QuestionType;

import java.io.Serializable;

public class OptionGroupDto implements Serializable {

    private String name;
    private Integer value;
    private QuestionType questionType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    @Override
    public String toString() {
        return "OptionGroupDto{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", questionType=" + questionType +
                '}';
    }
}
