package com.rhythmfinders.domain.member.aggregate;

public enum Gender {
    M("남자"), 
    F("여자");

    private final String label;

    Gender(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
