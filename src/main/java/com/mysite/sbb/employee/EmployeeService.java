package com.mysite.sbb.employee;

import java.time.LocalDateTime;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {
	private final EmployeeRepository employeeRepository;
	private final PasswordEncoder passwordEncoder;
	
	public Employee create(String nickname, String username, String email, String password) {
		Employee employee = new Employee();
		employee.setNickname(nickname);
		employee.setUsername(username);
		employee.setEmail(email);
		employee.setCreateDate(LocalDateTime.now());
		employee.setPassword(passwordEncoder.encode(password));
		this.employeeRepository.save(employee);
		
		return employee;
	}
}
