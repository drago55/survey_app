package com.horvat.dragutin.survey.dto;

import java.io.Serializable;
import java.util.List;

public class OptionsDto implements Serializable {

    private String text;
    private List<OptionGroupDto> optionGroup;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<OptionGroupDto> getOptionGroup() {
        return optionGroup;
    }

    public void setOptionGroup(List<OptionGroupDto> optionGroup) {
        this.optionGroup = optionGroup;
    }

    @Override
    public String toString() {
        return "OptionsDto{" +
                "text='" + text + '\'' +
                ", optionGroup=" + optionGroup +
                '}';
    }
}
