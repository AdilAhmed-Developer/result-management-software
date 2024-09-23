package com.management.rms.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.management.rms.entity.Branch;
import com.management.rms.entity.Student;
import com.management.rms.entity.Teacher;
import com.management.rms.service.BranchService;
import com.management.rms.service.StudentService;
import com.management.rms.service.TeacherService;

@Controller
public class TeacherController {
	
	private TeacherService teacherService;
	private BranchService branchService;

	public TeacherController(TeacherService teacherService,BranchService branchService) {
		super();
		this.teacherService = teacherService;
		this.branchService = branchService;
	}
	
	@GetMapping("/teachers")
	public String listTeachers(Model model) {
		model.addAttribute("teachers",teacherService.getAllTeachers());
		return "teachers";
		
	}
	
	@GetMapping("/teachers/new")
	public String createTeachersForm(Model model) {
		Teacher teacher  =  new Teacher();
		model.addAttribute("teacher",teacher);
		List<Branch> list = branchService.getAllBranchs();
		model.addAttribute("departments",list);
		return "create_teacher";
	}
	
	@PostMapping("/teachers")
	public String saveTeacher(@ModelAttribute("teacher") Teacher teacher) {
		teacherService.saveTeacher(teacher);
		return "redirect:/teachers";
	}
	
	@GetMapping("/teachers/edit/{id}")
	public String editTeacherForm(@PathVariable Long id, Model model) {
		model.addAttribute("teacher", teacherService.getTeacherById(id));
		model.addAttribute("departments", branchService.getAllBranchs());
		return "edit_teacher";
	}
	
	@PostMapping("/teachers/{id}")
	public String updateTeacher(@PathVariable Long id,
			@ModelAttribute("teacher") Teacher teacher,
			Model model) {
		
		// get student from database by id
		Teacher existingTeacher = teacherService.getTeacherById(id);
		existingTeacher.setId(id);
		existingTeacher.setTeacherName(teacher.getTeacherName());
		existingTeacher.setDepartment(teacher.getDepartment());
		
		// save updated teacher object
		teacherService.updateTeacher(existingTeacher);
		return "redirect:/teachers";		
	}
	
	// handler method to handle delete teacher request
	
	@GetMapping("/teachers/{id}")
	public String deleteTeacher(@PathVariable Long id) {
		teacherService.deleteTeacherById(id);
		return "redirect:/teachers";
	}

}
