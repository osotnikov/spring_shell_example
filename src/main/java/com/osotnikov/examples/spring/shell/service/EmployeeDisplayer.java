package com.osotnikov.examples.spring.shell.service;

import java.util.Collection;

import com.osotnikov.examples.spring.shell.db.entities.Employee;
import org.apache.commons.lang3.builder.RecursiveToStringStyle;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDisplayer {

	public String employeesAsString(Collection<Employee> employees) {

		StringBuilder sb = new StringBuilder();

		for(Employee employee : employees) {

			sb.append(new ReflectionToStringBuilder(employee, new RecursiveToStringStyle()).toString());
			sb.append("\n\n");

		}

		return sb.toString();
	}

}
