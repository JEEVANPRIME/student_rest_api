package com.example.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.student.dto.Student;

public interface StudentRepo extends JpaRepository<Student, String>{

	List<Student> findByName(String name);

	List<Student> findByBranch(String branch);

	List<Student> findByPhno(String phno); 
 
}
