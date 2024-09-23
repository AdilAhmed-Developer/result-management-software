package com.management.rms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.management.rms.entity.Student;
import com.management.rms.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject,Long>{
	 @Query(value = "SELECT * FROM subjects s WHERE s.branch =  :branch and s.semester = :semester",
	            nativeQuery = true)
	    List<Subject> findByBranchAndSemester(@Param("branch") String branch,@Param("semester") String semester);

}
