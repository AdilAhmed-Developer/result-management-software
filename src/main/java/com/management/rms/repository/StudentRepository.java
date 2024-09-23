package com.management.rms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.management.rms.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{
	 @Query(value = "SELECT * FROM students s WHERE s.branch =  :branch and s.semester = :semester",
	            nativeQuery = true)
	    List<Student> findByBranchAndSemester(@Param("branch") String branch,@Param("semester") String semester);

}
