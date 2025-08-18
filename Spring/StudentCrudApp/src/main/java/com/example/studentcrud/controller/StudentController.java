package com.example.studentcrud.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentcrud.entity.Student;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	private List<Student> studentList = new ArrayList<>();
	
	@PostMapping
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		studentList.add(student);
		return new ResponseEntity<>(student, HttpStatus.CREATED);
	}
	
	@GetMapping("/{studID}")
	public ResponseEntity<Student> getStudentById(@PathVariable long studID){
		Optional<Student> student =  studentList.stream().filter(s -> s.getId().equals(studID)).findFirst();
		
		if(student.isPresent())
				return new ResponseEntity<> (student.get(), HttpStatus.OK);
		else
				return new ResponseEntity<> (HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{studID}")
	public ResponseEntity<Student> updateStudent(@PathVariable long studID, @RequestBody Student updateStudent){
		for(int i = 0; i < studentList.size(); i++) {
			Student s = studentList.get(i);
			if(s.getId().equals(studID)) {
				s.setName(updateStudent.getName());
				s.setEmail(updateStudent.getEmail());
				return new ResponseEntity(s, HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{studID}")
	public ResponseEntity<Void> deleteStudetn(@PathVariable long studID){
		boolean removed = studentList.removeIf(s -> s.getId().equals(studID));
		
		if(removed) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
