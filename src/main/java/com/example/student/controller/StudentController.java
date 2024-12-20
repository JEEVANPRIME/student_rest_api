package com.example.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.dto.Student;
import com.example.student.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService service;

	@PostMapping("/student")
	public ResponseEntity<Object> save(@RequestBody Student student) {
		return service.save(student);
	}

	@PostMapping("/students")
	public ResponseEntity<Object> saveAll(@RequestBody List<Student> students) {
		return service.saveAll(students);
	}

	@GetMapping("/student/{usn}")
	public ResponseEntity<Object> findById(@PathVariable String usn) {
		return service.findById(usn);
	}

	@GetMapping("/student/name/{name}")
	public ResponseEntity<Object> findByName(@PathVariable String name){
		return service.findByName(name);  
	}
	
	@GetMapping("/student/branch/{branch}")
	public ResponseEntity<Object> findByBranch(@PathVariable String branch){
		return service.findByBranch(branch); 
	}
	
	@GetMapping("/student/phno/{phno}")
	public ResponseEntity<Object> findByPhno(@PathVariable String phno){
		return service.findByPhno(phno); 
	}
	
	@PutMapping("/student")
	public ResponseEntity<Object> update(@RequestBody Student student){
		return service.update(student); 
	}
	
	@PatchMapping("/student/{usn}")
	public ResponseEntity<Object> update(@PathVariable String usn,@RequestBody Student student){
		return service.update(usn,student); 
	}
	
	@DeleteMapping("/student/{usn}")
	public ResponseEntity<Object> delete(@PathVariable String usn){
		return service.delete(usn); 
	}
}
