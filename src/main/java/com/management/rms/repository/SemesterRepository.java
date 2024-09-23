package com.management.rms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.rms.entity.Branch;
import com.management.rms.entity.Semester;


public interface SemesterRepository extends JpaRepository<Semester,Long>{

}
