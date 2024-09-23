package com.management.rms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.management.rms.entity.Login;
import com.management.rms.entity.Student;

public interface LoginRepository extends JpaRepository<Login,Long>{

}
