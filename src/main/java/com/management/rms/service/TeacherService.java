package com.management.rms.service;

import java.util.List;

import com.management.rms.entity.Teacher;

public interface TeacherService {
	
	List<Teacher> getAllTeachers();
	
	Teacher saveTeacher(Teacher teacher);
	Teacher getTeacherById(Long id);
	Teacher updateTeacher(Teacher teacher);
	void deleteTeacherById(Long id);
}
