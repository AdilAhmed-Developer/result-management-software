package com.management.rms.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.management.rms.entity.Exam;
import com.management.rms.entity.Marks;
import com.management.rms.entity.Student;
import com.management.rms.entity.Subject;
import com.management.rms.service.BranchService;
import com.management.rms.service.ExamService;
import com.management.rms.service.MarksService;
import com.management.rms.service.SemesterService;
import com.management.rms.service.StudentService;
import com.management.rms.service.SubjectService;

import jakarta.servlet.http.HttpServletResponse;



@Controller
public class MarksController {
	
	private MarksService marksService;
	private StudentService studentsService;
	private ExamService examService;
	private SubjectService subjectService;
	private BranchService branchService;
	private SemesterService semesterService;

	public MarksController(StudentService studentsService, MarksService marksService,ExamService examService,SubjectService subjectService,BranchService branchService,SemesterService semesterService) {
		super();
		this.marksService = marksService;
		this.studentsService = studentsService;
		this.examService = examService;
		this.subjectService = subjectService;
		this.branchService = branchService;
		this.semesterService = semesterService;
	}
	
	@GetMapping("/export-to-excel")
	public void exportToExcel(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=Student_Result.xlsx";
		response.setHeader(headerKey, headerValue);
		marksService.exportResultToExcel(response);
	}
	
	
	
	@GetMapping("/marks")
	public String listMarks(Model model) {
		
		model.addAttribute("marks",marksService.getAllStudentsMarks());
		return "marks";
		
	}
	
	
	@GetMapping("/marks/new")
	public String createMarksForm(Model model) {
		Marks marks  =  new Marks();
		model.addAttribute("marks",marks);
		Exam exams  =  new Exam();
		model.addAttribute("examss",exams);
		
		model.addAttribute("exams",examService.getAllExams());
		model.addAttribute("departments",branchService.getAllBranchs());
		model.addAttribute("semesters",semesterService.getAllSemesters());
		model.addAttribute("students", studentsService.getAllStudents());
		return "create_marks";
		
	}
	
	

	@RequestMapping(path ="/search")
	public String submitForm(@ModelAttribute("user") Exam user,Model model) { 
		Marks marks  =  new Marks();
		model.addAttribute("marks",marks);
		Exam existingExam = examService.getExamById(Long.parseLong(user.getExamName()) );
		marks.setExamName(existingExam.getExamName());
		marks.setBranch(user.getExamBranch());
		marks.setSemester(user.getExamSem());
		marks.setSubjectMinMarks(existingExam.getMinMarks());
		marks.setSubjectMaxMarks(existingExam.getMaxMarks());
		List<Student> list = studentsService.findStudentsByKeyword(user.getExamBranch(),user.getExamSem());
		model.addAttribute("students", list);
		List<Subject> list2 = subjectService.findSubjectsByKeyword(user.getExamBranch(),user.getExamSem());
		model.addAttribute("subjects", list2);
		model.addAttribute("miniMarks",existingExam.getMinMarks());
		model.addAttribute("maxiMarks",existingExam.getMaxMarks());
			 		  
	    return "add_marks";
	}
	
	
	@PostMapping("/marks")
	public String saveMarks(@ModelAttribute("mark") Marks marks,Model model) {
		marks.setPercentage(marks.percentage());
		if(marks.status() == true) {
			marks.setResult("Passed");
		}else {
			marks.setResult("Failed");
		}
		
		model.addAttribute("marks",marks);
		marksService.saveMarks(marks);
		return "redirect:/marks";
	}
	
	@GetMapping("/marks/edit/{id}")
	public String editMarksForm(@PathVariable Long id, Model model) {
		model.addAttribute("mark", marksService.getMarkById(id));
		model.addAttribute("students",studentsService.getAllStudents());
		model.addAttribute("subjects",subjectService.getAllSubjects());
		model.addAttribute("departments",branchService.getAllBranchs());
		model.addAttribute("semesters",semesterService.getAllSemesters());
		model.addAttribute("exams",examService.getAllExams());
		
		return "edit_marks";
	}
	
	@PostMapping("/marks/{id}")
	public String updateMarks(@PathVariable Long id,
			@ModelAttribute("mark") Marks marks,
			Model model) {
		
		// get student from database by id
		Marks existingMarks = marksService.getMarkById(id);
		existingMarks.setId(id);
		existingMarks.setStudentName(marks.getStudentName());
		existingMarks.setBranch(marks.getBranch());
		existingMarks.setSemester(marks.getSemester());
		existingMarks.setExamName(marks.getExamName());
		existingMarks.setSubjectMinMarks(marks.getSubjectMinMarks());
		existingMarks.setSubjectMaxMarks(marks.getSubjectMaxMarks());
		
		existingMarks.setSubject1(marks.getSubject1());
		existingMarks.setSubject1ObtainedMarks(marks.getSubject1ObtainedMarks());
		
		existingMarks.setSubject2(marks.getSubject2());
		existingMarks.setSubject2ObtainedMarks(marks.getSubject2ObtainedMarks());
		
		existingMarks.setSubject3(marks.getSubject3());
		existingMarks.setSubject3ObtainedMarks(marks.getSubject3ObtainedMarks());
		
		existingMarks.setSubject4(marks.getSubject4());
		existingMarks.setSubject4ObtainedMarks(marks.getSubject4ObtainedMarks());
		
		existingMarks.setSubject5(marks.getSubject5());
		existingMarks.setSubject5ObtainedMarks(marks.getSubject5ObtainedMarks());
		
		// save updated student object
		marksService.updateMark(existingMarks);
		return "redirect:/marks";		
	}
	
	// handler method to handle delete student request
	
	@GetMapping("/marks/{id}")
	public String deleteStudent(@PathVariable Long id) {
		marksService.deleteMarkById(id);
		return "redirect:/marks";
	}

}
