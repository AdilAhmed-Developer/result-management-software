package com.management.rms.service.impl;

import java.io.IOException;
import java.util.List;


import org.springframework.stereotype.Service;

import com.management.rms.ExportUtils.ExportExcelUtils;
import com.management.rms.entity.Marks;
import com.management.rms.entity.Student;
import com.management.rms.entity.Subject;
import com.management.rms.repository.MarksRepository;
import com.management.rms.repository.StudentRepository;
import com.management.rms.repository.SubjectRepository;
import com.management.rms.service.MarksService;
import com.management.rms.service.StudentService;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class MarksServiceImpl implements MarksService{
	
	private MarksRepository  marksRepository;
	private SubjectRepository  subjectRepository;
	
	

	public MarksServiceImpl(MarksRepository marksRepository,SubjectRepository  subjectRepository) {
		super();
		this.marksRepository = marksRepository;
		this.subjectRepository = subjectRepository;
	}



	@Override
	public List<Marks> getAllStudentsMarks() {
		return marksRepository.findAll();
	}



	@Override
	public Marks saveMarks(Marks marks) {
		
		return marksRepository.save(marks);
	}



	@Override
	public Marks getMarkById(Long id) {
		return marksRepository.findById(id).get();
	}



	@Override
	public Marks updateMark(Marks marks) {
		return marksRepository.save(marks);
	}



	@Override
	public void deleteMarkById(Long id) {
		marksRepository.deleteById(id);
	}
	
	@Override
	public List<Marks> findByPassedStudents() {
		return marksRepository.findByPassedStudents();
	}
	
	@Override
	public int findByCountPassedStudents() {
		return marksRepository.findByPassedStudents().size();
	}
	
	
	
	
	public List<Marks> exportResultToExcel(HttpServletResponse response) throws IOException{
		List<Marks> marks = marksRepository.findAll();
		List<Subject> subjects = subjectRepository.findAll();
		int  count = marksRepository.findByPassedStudents().size();
		int  appeared = marksRepository.findAll().size();
		ExportExcelUtils exportUtils = new ExportExcelUtils(marks,subjects);		
		exportUtils.exportDataToExcel(response,count,appeared);
		return marks;
	}



	

}
