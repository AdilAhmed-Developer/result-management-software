package com.management.rms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.management.rms.entity.Branch;
import com.management.rms.entity.Semester;
import com.management.rms.entity.Student;
import com.management.rms.entity.Teacher;
import com.management.rms.service.SemesterService;
import com.management.rms.service.BranchService;
import com.management.rms.service.StudentService;
import com.management.rms.service.TeacherService;

@Controller
public class SemesterController {
	
	private SemesterService semesterService;

	public SemesterController(SemesterService semesterService) {
		super();
		this.semesterService = semesterService;
	}
	

	
	@GetMapping("/semesters/new")
	public String createSemesterForm(Model model) {
		Semester semester  =  new Semester();
		model.addAttribute("semesterValue",semester);
		return "create_semester";
	}
	
	@PostMapping("/semesters")
	public String saveSemester(@ModelAttribute("semesterValue") Semester semesterValue) {
		semesterService.saveSemester(semesterValue);
		return "redirect:/settings";
	}

	
	@GetMapping("/semesters/edit/{id}")
	public String editSemesterForm(@PathVariable Long id, Model model) {
		model.addAttribute("semesterValue", semesterService.getSemesterById(id));
		return "edit_semester";
	}
	
	@PostMapping("/semesters/{id}")
	public String updateSemester(@PathVariable Long id,
			@ModelAttribute("semesterValue") Semester semesterValue,
			Model model) {
		
		// get student from database by id
		Semester existingSemester = semesterService.getSemesterById(id);
		existingSemester.setId(id);
		existingSemester.setSemester(semesterValue.getSemester());
		
		// save updated teacher object
		semesterService.updateSemester(existingSemester);
		return "redirect:/settings";		
	}
	
	// handler method to handle delete teacher request
	
	@GetMapping("/semester/{id}")
	public String deleteSemester(@PathVariable Long id) {
		semesterService.deleteSemesterById(id);
		return "redirect:/settings";
	}

}
