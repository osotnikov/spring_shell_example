package com.osotnikov.examples.spring.shell.db.entities;

public enum EmployementType {

    CONTRACTOR("Contractor"),
    PERMANENT("Permanent");

    String type;

    EmployementType(String type) {
        this.type = type;
    }

    public static EmployementType fetchByType(String type) {
        for(EmployementType employementType : EmployementType.values()) {
            if(employementType.type == type) {
                return  employementType;
            }
        }
        return null;
    }
}
