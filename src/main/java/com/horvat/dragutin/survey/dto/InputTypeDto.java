package com.horvat.dragutin.survey.dto;

import java.io.Serializable;

public class InputTypeDto implements Serializable {

    private String inputTypeName;
    private String code;

    public String getInputTypeName() {
        return inputTypeName;
    }

    public void setInputTypeName(String inputTypeName) {
        this.inputTypeName = inputTypeName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "InputTypeDto{" +
                "inputTypeName='" + inputTypeName + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
