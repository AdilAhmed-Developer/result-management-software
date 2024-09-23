package com.management.rms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.management.rms.entity.Exam;
import com.management.rms.service.BranchService;
import com.management.rms.service.ExamService;
import com.management.rms.service.SemesterService;

@Controller
public class ExamController {
	
	private ExamService examService;
	private BranchService branchService;
	private SemesterService semesterService;

	public ExamController(ExamService examService,BranchService branchService,SemesterService semesterService) {
		super();
		this.examService = examService;
		this.branchService = branchService;
		this.semesterService = semesterService;
	}
	
	@GetMapping("/exams")
	public String listExam(Model model) {
		model.addAttribute("exams",examService.getAllExams());
		return "exams";
		
	}
	
	@GetMapping("/exams/new")
	public String createExamForm(Model model) {
		Exam exam  =  new Exam();
		model.addAttribute("exam",exam);
		model.addAttribute("departments",branchService.getAllBranchs());
		model.addAttribute("semesters",semesterService.getAllSemesters());
		return "create_exam";
	}
	
	@PostMapping("/exams")
	public String saveExam(@ModelAttribute("exam") Exam exam) {
		examService.saveExam(exam);
		return "redirect:/exams";
	}
	
	@GetMapping("/exams/edit/{id}")
	public String editExamForm(@PathVariable Long id, Model model) {
		model.addAttribute("exam", examService.getExamById(id));
		model.addAttribute("departments",branchService.getAllBranchs());
		model.addAttribute("semesters",semesterService.getAllSemesters());
		return "edit_exam";
	}
	
	@PostMapping("/exams/{id}")
	public String updateSubject(@PathVariable Long id,
			@ModelAttribute("exam") Exam exam,
			Model model) {
		
		// get student from database by id
		Exam existingExam = examService.getExamById(id);
		existingExam.setId(id);
		existingExam.setExamName(exam.getExamName());
		existingExam.setExamSem(exam.getExamSem());
		existingExam.setExamBranch(exam.getExamBranch());
		existingExam.setExamDate(exam.getExamDate());
		existingExam.setMinMarks(exam.getMinMarks());
		existingExam.setMaxMarks(exam.getMaxMarks());
		
		// save updated student object
		examService.updateExam(existingExam);
		return "redirect:/exams";		
	}
	
	// handler method to handle delete student request
	
	@GetMapping("/exams/{id}")
	public String deleteExam(@PathVariable Long id) {
		examService.deleteExamById(id);
		return "redirect:/exams";
	}

}
