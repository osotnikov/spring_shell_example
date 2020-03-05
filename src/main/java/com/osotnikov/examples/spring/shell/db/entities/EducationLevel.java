package com.osotnikov.examples.spring.shell.db.entities;

public enum EducationLevel {

    COLLEGE("College"),
    BACHELOR("University Degree"),
    MASTERS("Master's Degree"),
    PHD("Doctorate");

    private String level;

    EducationLevel(String level) {
        this.level = level;
    }

    public static EducationLevel fetchByLevel(String level) {
        for(EducationLevel educationLevel : EducationLevel.values()) {
            if(educationLevel.level == level) {
                return  educationLevel;
            }
        }
        return null;
    }
}
