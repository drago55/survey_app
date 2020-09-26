package com.horvat.dragutin.survey.enums;

public enum MatrixScaleEnum {
    VERY_GOOD("Very good"),
    GOOD("Good"),
    FAIR("Fair"),
    POOR("Poor"),
    VERY_POOR("Very poor");

    private String description;

    private MatrixScaleEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
