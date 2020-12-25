package com.horvat.dragutin.survey.enums;

public enum LikertScaleEnum {
    EXTREMELY_SATISFIED("Extremely satisfied"),
    VERY_SATISFIED("Very satisfied"),
    NEITHER_SATISFIED_NOR_DISSATISFIED("Neither satisfied nor dissatisfied"),
    NOT_SO_SATISFIED("Not so satisfied"),
    NOT_SATISFIED_AT_ALL("Not satisfied ata all");

    private final String description;

    LikertScaleEnum(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
