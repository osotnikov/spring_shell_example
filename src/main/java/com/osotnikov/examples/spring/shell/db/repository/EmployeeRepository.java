package com.osotnikov.examples.spring.shell.db.repository;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.osotnikov.examples.spring.shell.db.entities.Department;
import com.osotnikov.examples.spring.shell.db.entities.Employee;

@Repository
public class EmployeeRepository {

	Set<Employee> employees = new HashSet<>();

	private void init() {
		Employee employee = new Employee();
		employee.setBirthDate(
			new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime());
		employee.setDepartment(Department.ACCOUNTING);
		employee.setEducationLevel("University");
		employees.add(employee);
	}

	public List<Employee> findEmployeesBy(String payType, Long departmentId, String educationLevel) {

		return employees.stream().filter(employee -> {
			if(payType != null) {
				if() {
					employee.getPosition();
				}
			}
			if(departmentId != null) {

			}
			if(educationLevel != null) {

			}
		}).collect(Collectors.toList());
	}

}
