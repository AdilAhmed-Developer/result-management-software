package com.management.rms.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.management.rms.entity.Student;
import com.management.rms.entity.Subject;
import com.management.rms.entity.Teacher;
import com.management.rms.service.BranchService;
import com.management.rms.service.SemesterService;
import com.management.rms.service.StudentService;
import com.management.rms.service.SubjectService;
import com.management.rms.service.TeacherService;

@Controller
public class SubjectController {
	
	private SubjectService subjectService;
	private TeacherService teacherService;
	private BranchService branchService;
	private SemesterService semesterService;

	public SubjectController(SubjectService subjectService,TeacherService teacherService,BranchService branchService,SemesterService semesterService) {
		super();
		this.subjectService = subjectService;
		this.teacherService = teacherService;
		this.branchService = branchService;
		this.semesterService = semesterService;
	}
	
	@GetMapping("/subjects")
	public String listSubject(Model model) {
		model.addAttribute("subjects",subjectService.getAllSubjects());
		return "subjects";
		
	}
	
	@GetMapping("/subjects/new")
	public String createSubjectForm(Model model) {
		Subject subject  =  new Subject();
		model.addAttribute("subject",subject);
		model.addAttribute("departments",branchService.getAllBranchs());
		model.addAttribute("semesters",semesterService.getAllSemesters());
		List<Teacher> list = subjectService.getAllTeachers();
		model.addAttribute("teacher",list);
		return "create_subject";
	}
	
	@PostMapping("/subjects")
	public String saveSubject(@ModelAttribute("subject") Subject subject) {
		subjectService.saveSubject(subject);
		return "redirect:/subjects";
	}
	
	@GetMapping("/subjects/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("subject", subjectService.getSubjectById(id));
		model.addAttribute("departments",branchService.getAllBranchs());
		model.addAttribute("semesters",semesterService.getAllSemesters());
		return "edit_subject";
	}
	
	@PostMapping("/subjects/{id}")
	public String updateSubject(@PathVariable Long id,
			@ModelAttribute("subject") Subject subject,
			Model model) {
		
		// get student from database by id
		Subject existingSubject = subjectService.getSubjectById(id);
		existingSubject.setId(id);
		existingSubject.setSubjectName(subject.getSubjectName());
		existingSubject.setSemester(subject.getSemester());
		existingSubject.setBranch(subject.getBranch());
		existingSubject.setAllocatedTeacher(subject.getAllocatedTeacher());
		existingSubject.setType(subject.getType());
		
		
		// save updated student object
		subjectService.updateSubject(existingSubject);
		return "redirect:/subjects";		
	}
	
	// handler method to handle delete student request
	
	@GetMapping("/subjects/{id}")
	public String deleteSubject(@PathVariable Long id) {
		subjectService.deleteSubjectById(id);
		return "redirect:/subjects";
	}

}
