package com.management.rms.service;

import java.util.List;

import com.management.rms.entity.Branch;


public interface BranchService {
	
	List<Branch> getAllBranchs();
	
	Branch saveBranch(Branch settings);
	Branch getBranchById(Long id);
	Branch updateBranch(Branch settings);
	void deleteBranchById(Long id);
}
