package com.osotnikov.examples.spring.shell.db.repository;

import java.util.*;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.osotnikov.examples.spring.shell.db.entities.Department;
import com.osotnikov.examples.spring.shell.db.entities.Employee;
import com.osotnikov.examples.spring.shell.db.entities.Position;

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

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);

		Root<Employee> employee = cq.from(Employee.class);

		Join<Employee, Department> department = employee.join("department");
		Join<Employee, Position> position = employee.join("position");

		employee.fetch("position", JoinType.INNER);
		employee.fetch("department", JoinType.INNER);

		List<Predicate> predicatesList = new LinkedList<>();
		if (payType != null) {
			predicatesList.add(cb.equal(position.get("payType"), payType));
		}
		if (departmentId != null) {
			predicatesList.add(cb.equal(department.get("departmentId"), departmentId));
		}
		if (educationLevel != null) {
			predicatesList.add(cb.equal(employee.get("educationLevel"), educationLevel));
		}

		Predicate[] predicates = new Predicate[0];
		predicates = predicatesList.toArray(predicates);

		cq.where(predicates);

		TypedQuery<Employee> tq = em.createQuery(cq);

		EntityGraph<Employee> loadGraph = (EntityGraph<Employee>) em.createEntityGraph("Employee.department");
		tq.setHint("javax.persistence.loadgraph", loadGraph);
		loadGraph = (EntityGraph<Employee>) em.createEntityGraph("Employee.position");
		tq.setHint("javax.persistence.loadgraph", loadGraph);

		return tq.getResultList();
	}

}
