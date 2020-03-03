package com.osotnikov.examples.spring.shell.cli;

import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.osotnikov.examples.spring.shell.db.entities.Employee;
import com.osotnikov.examples.spring.shell.db.repository.EmployeeRepository;
import com.osotnikov.examples.spring.shell.service.EmployeeDisplayer;
import com.osotnikov.examples.spring.shell.stringcompare.StringCompareService;

@ExtendWith(MockitoExtension.class)
public class SpringShellExampleApplicationTest {

	@Mock
	StringCompareService stringCompareService;

	@Mock
	EmployeeRepository employeeRepository;

	@Mock
	EmployeeDisplayer employeeDisplayer;

	@InjectMocks
	SpringShellExampleApplication springShellExampleApplication;

	@Test
	public void testFindNumberOfDifferencesInEqualLengthStrings_Success() {

		when(stringCompareService.findNumberOfDifferencesInEqualLengthStrings("ABCDΩ", "ABCDΩ")).thenReturn(0);
		Assertions.assertEquals(0, springShellExampleApplication.findNumberOfDifferencesInEqualLengthStrings("ABCDΩ", "ABCDΩ"));

		when(stringCompareService.findNumberOfDifferencesInEqualLengthStrings("ABCDΩ", "ABXXX")).thenReturn(3);
		Assertions.assertEquals(3, springShellExampleApplication.findNumberOfDifferencesInEqualLengthStrings("ABCDΩ", "ABXXX"));

	}

	@Test
	public void testFindEmployeesBy_Success() {

		List<Employee> employeeList = new LinkedList<>();
		Employee employee = new Employee();
		employee.setEmployeeId(100);
		employeeList.add(employee);

		when(employeeRepository.findEmployeesBy("", 0l, "")).thenReturn(employeeList);

		String employeesAsString = "the correct list of employees...";
		when(employeeDisplayer.employeesAsString(employeeList)).thenReturn(employeesAsString);

		Assertions.assertEquals(employeesAsString, springShellExampleApplication.findEmployeesBy("", 0l, ""));

	}

}
