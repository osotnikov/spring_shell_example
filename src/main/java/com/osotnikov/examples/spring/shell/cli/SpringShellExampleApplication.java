package com.osotnikov.examples.spring.shell.cli;

import java.util.List;

import com.osotnikov.examples.spring.shell.db.entities.Department;
import com.osotnikov.examples.spring.shell.db.entities.EducationLevel;
import com.osotnikov.examples.spring.shell.db.entities.Employee;
import com.osotnikov.examples.spring.shell.db.entities.EmployementType;
import com.osotnikov.examples.spring.shell.service.EmployeeDisplayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import com.osotnikov.examples.spring.shell.db.repository.EmployeeRepository;
import com.osotnikov.examples.spring.shell.stringcompare.StringCompareService;

@ShellComponent
public class SpringShellExampleApplication {

	@Autowired
	StringCompareService stringCompareService;

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	EmployeeDisplayer employeeDisplayer;

	@ShellMethod(key="diffeq",value="Find the number of differences in equal length strings. Provide two arguments. They must be strings of equal lengths.")
	public int findNumberOfDifferencesInEqualLengthStrings(
			@ShellOption String str1,
			@ShellOption String str2) {

		return stringCompareService.findNumberOfDifferencesInEqualLengthStrings(str1, str2);
	}

	@ShellMethod(key = "find-employee", value = "Find all employees by these parameters in the specific order: payment type, " +
			"department id and education level. Prefix arguments with --employment-type/-p, --department-id/-d and --education-level/-e flags for " +
			"ease of use (prefixes allow any ordering of arguments). You can omit some or all of the arguments, the query " +
			"will not be restricted by these arguments in that case.")
	public String findEmployeesBy(
			@ShellOption(value = {"-t", "--employment-type"}, defaultValue=ShellOption.NULL)  String employmentType,
			@ShellOption(value = {"-d", "--department-id"}, defaultValue=ShellOption.NULL) int departmentId,
			@ShellOption(value = {"-e", "--education-level"}, defaultValue=ShellOption.NULL) String educationLevel) {

		List<Employee> employees = employeeRepository.findEmployeesBy(
			EmployementType.fetchByType(employmentType), Department.fetchById(departmentId), EducationLevel.fetchByLevel(educationLevel));

		return employeeDisplayer.employeesAsString(employees);
	}

}
