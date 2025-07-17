package com.mysite.sbb.employee;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/empl")
public class EmployeeController {
	private final EmployeeService employeeService;
	
	@GetMapping("/create")
	public String emplCreate() {
		return "empl_create";
	}
	
	@PostMapping("/create")
	public String emlpCreate(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("nickname") String nickname, @RequestParam("email") String email) {
		this.employeeService.create(nickname, username, email, password);
		return "redirect:/";
	}
	
	@GetMapping("/login")
	public String emplLogin() {
		return "login_form";
	}
}
