package com.osotnikov.examples.spring.shell.db.entities;

public enum Department {

	HUMAN_RESOURCES(0),
	IT(1),
	ACCOUNTING(2),
	MARKETING(3);

	private int id;

	Department(int id) {
		this.id = id;
	}

	public static Department fetchById(int id) {
		for(Department department : Department.values()) {
			if(department.id == id) {
				return  department;
			}
		}
		return null;
	}
}
