package com.management.rms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.management.rms.entity.Exam;
import com.management.rms.entity.Subject;
import com.management.rms.repository.ExamRepository;
import com.management.rms.repository.SubjectRepository;
import com.management.rms.service.ExamService;
import com.management.rms.service.SubjectService;

@Service
public class ExamServiceImpl implements ExamService{
	
	private ExamRepository  examRepository;
	
	

	public ExamServiceImpl(ExamRepository examRepository) {
		super();
		this.examRepository = examRepository;
	}



	@Override
	public List<Exam> getAllExams() {
		return examRepository.findAll();
	}



	@Override
	public Exam saveExam(Exam exam) {
		
		return examRepository.save(exam);
	}



	@Override
	public Exam getExamById(Long id) {
		return examRepository.findById(id).get();
	}



	@Override
	public Exam updateExam(Exam exam) {
		return examRepository.save(exam);
	}



	@Override
	public void deleteExamById(Long id) {
		examRepository.deleteById(id);
	}

}
