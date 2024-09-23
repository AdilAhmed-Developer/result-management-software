package com.management.rms.service;

import java.util.List;

import com.management.rms.entity.Exam;

public interface ExamService {
	
	List<Exam> getAllExams();
	
	Exam saveExam(Exam exam);
	Exam getExamById(Long id);
	Exam updateExam(Exam exam);
	void deleteExamById(Long id);
}
