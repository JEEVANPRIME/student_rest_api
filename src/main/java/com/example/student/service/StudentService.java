package com.example.student.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ExitCodeEvent;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.student.dto.Student;
import com.example.student.repository.StudentRepo;

@Service
public class StudentService {

	@Autowired
	UsnGenerator generator;

	@Autowired
	StudentRepo repo;

	public ResponseEntity<Object> save(Student student) {

		String usn = generator.generatorUSN(student);
		student.setUsn(usn);

		repo.save(student);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "Student got admitted");
		map.put("Student is: ", student);

		return new ResponseEntity<Object>(map, HttpStatus.CREATED);
	}

	public ResponseEntity<Object> saveAll(List<Student> students) {

		repo.saveAll(students);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "Student got admitted");
		map.put("Student is: ", students);

		return new ResponseEntity<Object>(map, HttpStatus.CREATED);
	}

	public ResponseEntity<Object> findById(String usn) {
		Optional<Student> fetch = repo.findById(usn);
		if (fetch.isPresent()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("Student details found", fetch);
			return new ResponseEntity<Object>(map, HttpStatus.FOUND);
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("Student details found", fetch);
			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<Object> findByName(String name) {
		List<Student> fetch = repo.findByName(name);
		if (fetch.isEmpty()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("Student details found", fetch);
			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("Student details found", fetch);
			return new ResponseEntity<Object>(map, HttpStatus.FOUND);

		}
	}

	public ResponseEntity<Object> findByBranch(String branch) {
		List<Student> fetch = repo.findByBranch(branch);
		if (fetch.isEmpty()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("Student details found", fetch);
			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("Student details found", fetch);
			return new ResponseEntity<Object>(map, HttpStatus.FOUND);

		}
	}

	public ResponseEntity<Object> findByPhno(String phno) {
		List<Student> fetch = repo.findByPhno(phno);
		if (fetch.isEmpty()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("Student details found", fetch);
			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("Student details found", fetch);
			return new ResponseEntity<Object>(map, HttpStatus.FOUND);

		}
	}

	public ResponseEntity<Object> update(Student student) {
		String usn = generator.generatorUSN(student);
		student.setUsn(usn);

		repo.save(student);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "Student got admitted");
		map.put("Student is: ", student);

		return new ResponseEntity<Object>(map, HttpStatus.OK);
	}

	public ResponseEntity<Object> update(String usn, Student student) {
		Optional<Student> fetch = repo.findById(usn);
		if (fetch.isPresent()) {
			Student existStudent = fetch.get();
			if (student.getName() != null) {
				existStudent.setName(student.getName());
			} else if (student.getUsn() != null) {
				existStudent.setUsn(student.getUsn());
			} else if (student.getPhno() != null) {
				existStudent.setPhno(student.getPhno());
			} else if (student.getYoa() != null) {
				existStudent.setYoa(student.getYoa());
			} else if (student.getBranch() != null) {
				existStudent.setBranch(student.getBranch());
			}

			repo.save(existStudent);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("Data updated", existStudent);
			return new ResponseEntity<Object>(map, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<Object>("no data found and updated", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<Object> delete(String usn) {
		repo.deleteById(usn);
		return new ResponseEntity<Object>("student data deleted with usn:"+usn, HttpStatus.GONE); 
	}

}
