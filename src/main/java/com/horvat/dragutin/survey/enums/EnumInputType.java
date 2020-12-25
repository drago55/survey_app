package com.horvat.dragutin.survey.enums;

public enum EnumInputType {

    CHECK_BOX("CheckBox"), MULTI_CHECK_BOX("MultiCheckBox"),
    RADIO_BUTTON("RadioButton"), LETTER_BOX("LetterBox"), FREE_INPUT("FreeInput");

    private final String description;

    EnumInputType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
