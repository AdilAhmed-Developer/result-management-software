package com.management.rms.service.impl;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.management.rms.entity.Login;
import com.management.rms.entity.Student;
import com.management.rms.repository.LoginRepository;
import com.management.rms.repository.StudentRepository;
import com.management.rms.service.LoginService;
import com.management.rms.service.StudentService;

@Service
public class LoginServiceImpl implements LoginService{
	
	private LoginRepository  loginRepository;
	
	

	public LoginServiceImpl(LoginRepository loginRepository) {
		super();
		this.loginRepository = loginRepository;
	}



	@Override
	public List<Login> getAllUsers() {
		return loginRepository.findAll();
	}
	




}
