package com.management.rms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.management.rms.entity.Branch;
import com.management.rms.entity.Teacher;
import com.management.rms.repository.BranchRepository;
import com.management.rms.repository.TeacherRepository;
import com.management.rms.service.BranchService;
import com.management.rms.service.TeacherService;

@Service
public class BranchServiceImpl implements BranchService{
	
	private BranchRepository  branchRepository;
	
	

	public BranchServiceImpl(BranchRepository branchRepository) {
		super();
		this.branchRepository = branchRepository;
	}



	@Override
	public List<Branch> getAllBranchs() {
		return branchRepository.findAll();
	}



	@Override
	public Branch saveBranch(Branch branch) {
		return branchRepository.save(branch);
	}



	@Override
	public Branch getBranchById(Long id) {
		return branchRepository.findById(id).get();
	}



	@Override
	public Branch updateBranch(Branch branch) {
		return branchRepository.save(branch);
	}



	@Override
	public void deleteBranchById(Long id) {
		branchRepository.deleteById(id);
	}

}
