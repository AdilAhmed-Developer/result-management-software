package com.management.rms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.management.rms.entity.Login;
import com.management.rms.entity.Marks;
import com.management.rms.entity.Student;
import com.management.rms.service.BranchService;
import com.management.rms.service.LoginService;
import com.management.rms.service.MarksService;
import com.management.rms.service.SemesterService;
import com.management.rms.service.StudentService;
import com.management.rms.service.SubjectService;



@Controller
public class LoginController {
	
	private LoginService loginService;

	public LoginController(LoginService loginService) {
		super();
		this.loginService = loginService;
	}
	
	
	@GetMapping({"/", "/login"})
	public String login(Model model) {
		Login login  =  new Login();
		model.addAttribute("login",login);
		return "login";
		
	}

	
	@PostMapping("/loginUser")
	public String authorise(@ModelAttribute("login") Login login) {
		 if(login.getUserName().equals("Amir Sir") && login.getPassword().equals("Admin@123") ) {
			 return "redirect:/students";
		 }else {
			 return "login";
		 }
		
	}
	
	
	

}
