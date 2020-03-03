package com.osotnikov.examples.spring.shell.db.entities;

public enum EducationLevel {

    COLLEGE("College"),
    BACHELOR("University Degree"),
    MASTERS("Master's Degree"),
    PHD("Doctorate");

    private String educationLevel;

    EducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }
}
