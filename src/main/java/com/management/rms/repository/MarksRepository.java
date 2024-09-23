package com.management.rms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.management.rms.entity.Marks;
import com.management.rms.entity.Student;

public interface MarksRepository extends JpaRepository<Marks,Long>{
	@Query(value = "SELECT * FROM marks m WHERE m.result =  'Passed'",
            nativeQuery = true)
    List<Marks> findByPassedStudents();
	
	

}
