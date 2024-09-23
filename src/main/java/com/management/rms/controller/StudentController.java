package com.management.rms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.management.rms.entity.Marks;
import com.management.rms.entity.Student;
import com.management.rms.service.BranchService;
import com.management.rms.service.MarksService;
import com.management.rms.service.SemesterService;
import com.management.rms.service.StudentService;
import com.management.rms.service.SubjectService;



@Controller
public class StudentController {
	
	private StudentService studentService;
	private BranchService branchService;
	private SemesterService semesterService;

	public StudentController(StudentService studentService,BranchService branchService,SemesterService semesterService) {
		super();
		this.studentService = studentService;
		this.branchService = branchService;
		this.semesterService = semesterService;
	}
	
	
	
	
	@GetMapping("/students")
	public String listStudent(Model model) {
		model.addAttribute("students",studentService.getAllStudents());
		return "students";
		
	}
	

	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		Student student  =  new Student();
		model.addAttribute("student",student);
		model.addAttribute("departments",branchService.getAllBranchs());
		model.addAttribute("semesters",semesterService.getAllSemesters());
		return "create_student";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		model.addAttribute("departments",branchService.getAllBranchs());
		model.addAttribute("semesters",semesterService.getAllSemesters());
		return "edit_student";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id,
			@ModelAttribute("student") Student student,
			Model model) {
		
		// get student from database by id
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFullName(student.getFullName());
		existingStudent.setBranch(student.getBranch());
		existingStudent.setSemester(student.getSemester());
		existingStudent.setEnrollNo(student.getEnrollNo());
		
		// save updated student object
		studentService.updateStudent(existingStudent);
		return "redirect:/students";		
	}
	
	// handler method to handle delete student request
	
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}

}
