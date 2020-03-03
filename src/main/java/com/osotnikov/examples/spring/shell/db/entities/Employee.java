package com.osotnikov.examples.spring.shell.db.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee {

	private EducationLevel educationLevel;
	private int employeeId;
	private String name;
	private Department department;
	private EmployementType employementType;
}
