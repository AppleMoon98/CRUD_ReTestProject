package com.mysite.sbb.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeSecurityService implements UserDetailsService{
	private final EmployeeRepository employeeRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Employee> _employee = this.employeeRepository.findByUsername(username);
		
		if(_employee.isEmpty())
			throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
		
		Employee employee = _employee.get();
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(returnRole(username));
		
		return new User(employee.getUsername(), employee.getPassword(), authorities);
	}
	
	private SimpleGrantedAuthority returnRole(String username) {
		if("admin".equals(username))
			return new SimpleGrantedAuthority(EmployeeRole.ADMIN.getValue());
		else
			return new SimpleGrantedAuthority(EmployeeRole.USER.getValue());
	}

}
