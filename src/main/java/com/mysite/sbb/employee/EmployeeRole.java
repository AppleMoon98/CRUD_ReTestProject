package com.mysite.sbb.employee;

import lombok.Getter;

@Getter
public enum EmployeeRole {
	ADMIN("ROLE_ADMIN"), USER("ROLE_USER");
	
	String value;
	private EmployeeRole(String value) {
		this.value = value;
	}
}
