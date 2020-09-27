package com.horvat.dragutin.survey.dto;

import com.horvat.dragutin.survey.enums.QuestionType;
import com.horvat.dragutin.survey.model.InputType;

import java.io.Serializable;
import java.util.List;

public class QuestionDto implements Serializable {

    private String text;
    private List<OptionsDto> options;
    private QuestionType questionType;
    private Boolean allowMultipleOptions;
    private InputTypeDto inputType;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<OptionsDto> getOptions() {
        return options;
    }

    public void setOptions(List<OptionsDto> options) {
        this.options = options;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public Boolean getAllowMultipleOptions() {
        return allowMultipleOptions;
    }

    public void setAllowMultipleOptions(Boolean allowMultipleOptions) {
        this.allowMultipleOptions = allowMultipleOptions;
    }

    public InputTypeDto getInputType() {
        return inputType;
    }

    public void setInputType(InputTypeDto inputType) {
        this.inputType = inputType;
    }

    @Override
    public String toString() {
        return "QuestionDto{" +
                "text='" + text + '\'' +
                ", options=" + options +
                ", questionType=" + questionType +
                ", allowMultipleOptions=" + allowMultipleOptions +
                ", inputType=" + inputType +
                '}';
    }
}
