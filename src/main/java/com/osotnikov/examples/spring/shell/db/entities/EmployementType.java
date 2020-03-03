package com.osotnikov.examples.spring.shell.db.entities;

public enum EmployementType {

    CONTRACTOR("Contractor"),
    PERMANENT("Permanent");

    String employmentType;

    EmployementType(String employmentType) {
        this.employmentType = employmentType;
    }
}
