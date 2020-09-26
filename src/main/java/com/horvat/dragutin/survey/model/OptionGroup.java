package com.horvat.dragutin.survey.model;

import com.horvat.dragutin.survey.enums.QuestionType;

import javax.persistence.*;
import java.util.Set;

@Entity
public class OptionGroup extends BaseEntity implements Comparable<OptionGroup>{

    private String name;
    private Integer value;

    @Enumerated(EnumType.ORDINAL)
    private QuestionType questionType;

    @ManyToMany(mappedBy = "optionGroup")
    private Set<Options> options;

    public OptionGroup(){}

    public OptionGroup(String name, Integer value, QuestionType questionType) {
        this.questionType = questionType;
        this.name = name;
        this.value = value;
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

    @Override
    public int compareTo(OptionGroup o) {
        return this.value.compareTo(o.getValue());
    }

    @Override
    public String toString() {
        return "OptionGroup{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", questionType=" + questionType +
                '}';
    }

}
