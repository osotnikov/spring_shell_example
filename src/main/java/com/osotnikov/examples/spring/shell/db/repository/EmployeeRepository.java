package com.osotnikov.examples.spring.shell.db.repository;

import java.util.*;
import java.util.stream.Collectors;

import com.osotnikov.examples.spring.shell.db.entities.EducationLevel;
import com.osotnikov.examples.spring.shell.db.entities.EmployementType;
import org.springframework.stereotype.Repository;

import com.osotnikov.examples.spring.shell.db.entities.Department;
import com.osotnikov.examples.spring.shell.db.entities.Employee;

@Repository
public class EmployeeRepository {

	Set<Employee> employees = new HashSet<>();

	private void init() {

		employees.add(
			Employee.builder()
				.employeeId(0)
				.department(Department.ACCOUNTING)
				.educationLevel(EducationLevel.BACHELOR)
				.employementType(EmployementType.CONTRACTOR)
				.name("James Hetfield")
				.build());
		employees.add(
			Employee.builder()
				.employeeId(1)
				.department(Department.ACCOUNTING)
				.educationLevel(EducationLevel.COLLEGE)
				.employementType(EmployementType.PERMANENT)
				.name("Lars Ulrich")
				.build());
		employees.add(
			Employee.builder()
				.employeeId(2)
				.department(Department.HUMAN_RESOURCES)
				.educationLevel(EducationLevel.MASTERS)
				.employementType(EmployementType.PERMANENT)
				.name("Kirk Hamett")
				.build());
	}

	public List<Employee> findEmployeesBy(String payType, Long departmentId, String educationLevel) {

		return employees.stream().filter(employee -> {
			if(payType != null) {
				if() {
					employee.getr;
				}
			}
			if(departmentId != null) {

			}
			if(educationLevel != null) {

			}
		}).collect(Collectors.toList());
	}

}
