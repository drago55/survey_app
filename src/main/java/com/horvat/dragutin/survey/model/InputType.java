package com.horvat.dragutin.survey.model;

import javax.persistence.Entity;

@Entity
public class InputType extends BaseEntity{

    private String inputTypeName;
    private Integer code;

    public InputType(){}

    public InputType(String inputTypeName, Integer code) {
        this.code = code;
        this.inputTypeName = inputTypeName;
    }

    public String getInputTypeName() {
        return inputTypeName;
    }

    public void setInputTypeName(String inputTypeName) {
        this.inputTypeName = inputTypeName;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "InputType{" +
                "inputTypeName='" + inputTypeName + '\'' +
                ", code=" + code +
                '}';
    }
}
