package com.management.rms.controller;

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
import com.management.rms.service.SemesterService;
import com.management.rms.service.StudentService;
import com.management.rms.service.TeacherService;

@Controller
public class BranchController {
	
	private BranchService branchService;
	private SemesterService semesterService;

	public BranchController(BranchService branchService,SemesterService semesterService) {
		super();
		this.branchService = branchService;
		this.semesterService = semesterService;
	}
	
	@GetMapping("/settings")
	public String listBranch(Model model) {
		model.addAttribute("branchs",branchService.getAllBranchs());
		model.addAttribute("semesters",semesterService.getAllSemesters());
		return "settings";
		
	}
	
	@GetMapping("/branch/new")
	public String createBranchForm(Model model) {
		Branch branch  =  new Branch();
		model.addAttribute("branchValue",branch);
		return "create_branch";
	}
	
	@PostMapping("/branchs")
	public String saveBranch(@ModelAttribute("branchValue") Branch branchValue) {
		branchService.saveBranch(branchValue);
		return "redirect:/settings";
	}
	
	
	@GetMapping("/branchs/edit/{id}")
	public String editBranchForm(@PathVariable Long id, Model model) {
		model.addAttribute("branchValue", branchService.getBranchById(id));
		return "edit_branch";
	}
	
	@PostMapping("/branchs/{id}")
	public String updateBranch(@PathVariable Long id,
			@ModelAttribute("branchValue") Branch branchValue,
			Model model) {
		
		// get student from database by id
		Branch existingSettings = branchService.getBranchById(id);
		existingSettings.setId(id);
		existingSettings.setBranch(branchValue.getBranch());
		
		// save updated teacher object
		branchService.updateBranch(existingSettings);
		return "redirect:/settings";		
	}
	
	// handler method to handle delete teacher request
	
	@GetMapping("/branchs/{id}")
	public String deleteBranch(@PathVariable Long id) {
		branchService.deleteBranchById(id);
		return "redirect:/settings";
	}

}
