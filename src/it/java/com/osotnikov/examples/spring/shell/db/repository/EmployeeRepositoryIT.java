package com.osotnikov.examples.spring.shell.db.repository;

import java.util.List;

import org.apache.commons.lang3.builder.RecursiveToStringStyle;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.osotnikov.examples.spring.shell.db.entities.Employee;

@ExtendWith(SpringExtension.class)
@SpringBootTest(properties = { // Disable spring shell so it won't kick in during tests.
		InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
		ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
})
public class EmployeeRepositoryIT {

	private Logger logger = LogManager.getLogger(EmployeeRepositoryIT.class);

	private static final long DEPARTMENT_ID = 1L;
	private static final String PAYMENT_TYPE = "Monthly";
	private static final String EDUCATION_LEVEL = "Graduate Degree";

	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	public void testFetchEmployees_WithAllArguments_Success() {

		List<Employee> employees = employeeRepository.findEmployeesBy(PAYMENT_TYPE, DEPARTMENT_ID, EDUCATION_LEVEL);

		logger.info(
				"\n\nFor:\n\tpayment type: {}\n\tdepartment id: {}\n\teducation level: {}\n\nFound these employees: \n\n",
				PAYMENT_TYPE, DEPARTMENT_ID, EDUCATION_LEVEL);

		for(Employee employee : employees) {

			logger.info(new ReflectionToStringBuilder(employee, new RecursiveToStringStyle()).toString() + "\n");

			Assertions.assertEquals(PAYMENT_TYPE, employee.getPosition().getPayType());
			Assertions.assertEquals(DEPARTMENT_ID, employee.getDepartment().getDepartmentId());
			Assertions.assertEquals(EDUCATION_LEVEL, employee.getEducationLevel(), EDUCATION_LEVEL);
		}

	}

	@Test
	public void testFetchEmployees_WithPayTypeNull_Success() {

		List<Employee> employees = employeeRepository.findEmployeesBy(null, DEPARTMENT_ID, EDUCATION_LEVEL);

		logger.info(
				"\n\nFor:\n\tpayment type: {}\n\tdepartment id: {}\n\teducation level: {}\n\nFound these employees: \n\n",
				null, DEPARTMENT_ID, EDUCATION_LEVEL);

		for(Employee employee : employees) {

			logger.info(new ReflectionToStringBuilder(employee, new RecursiveToStringStyle()).toString() + "\n");

			Assertions.assertEquals(DEPARTMENT_ID, employee.getDepartment().getDepartmentId());
			Assertions.assertEquals(EDUCATION_LEVEL, employee.getEducationLevel(), EDUCATION_LEVEL);
		}

	}

	@Test
	public void testFetchEmployees_WithDepartmentIdNull_Success() {

		List<Employee> employees = employeeRepository.findEmployeesBy(PAYMENT_TYPE, null, EDUCATION_LEVEL);

		logger.info(
				"\n\nFor:\n\tpayment type: {}\n\tdepartment id: {}\n\teducation level: {}\n\nFound these employees: \n\n",
				PAYMENT_TYPE, null, EDUCATION_LEVEL);

		for(Employee employee : employees) {

			logger.info(new ReflectionToStringBuilder(employee, new RecursiveToStringStyle()).toString() + "\n");

			Assertions.assertEquals(PAYMENT_TYPE, employee.getPosition().getPayType());
			Assertions.assertEquals(EDUCATION_LEVEL, employee.getEducationLevel(), EDUCATION_LEVEL);
		}

	}

	@Test
	public void testFetchEmployees_WithEducationLevelNull_Success() {

		List<Employee> employees = employeeRepository.findEmployeesBy(PAYMENT_TYPE, DEPARTMENT_ID, null);

		logger.info(
				"\n\nFor:\n\tpayment type: {}\n\tdepartment id: {}\n\teducation level: {}\n\nFound these employees: \n\n",
				PAYMENT_TYPE, DEPARTMENT_ID, null);

		for(Employee employee : employees) {

			logger.info(new ReflectionToStringBuilder(employee, new RecursiveToStringStyle()).toString() + "\n");

			Assertions.assertEquals(PAYMENT_TYPE, employee.getPosition().getPayType());
			Assertions.assertEquals(DEPARTMENT_ID, employee.getDepartment().getDepartmentId());
		}

	}

}
