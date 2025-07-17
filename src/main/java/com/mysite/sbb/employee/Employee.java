package com.mysite.sbb.employee;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 6)
	private String nickname;
	
	@Column(unique = true)
	private String username;
	private String password;
	
	@Column(unique = true)
	private String email;
	private LocalDateTime createDate;
}
