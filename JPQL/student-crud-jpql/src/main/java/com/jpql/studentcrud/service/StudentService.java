package com.jpql.studentcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpql.studentcrud.entity.Student;
import com.jpql.studentcrud.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	//CREATE
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}
	
	//READ
	public List<Student> getAllStudents() {
		return studentRepository.getAllStudents();
	}
	public Student getStudentById(Long id) {
		return studentRepository.getStudentById(id);
	}
	
	//UPDATE
	public Student updateStudent(Long id, Student updatedStudent) {
		int rows = studentRepository.updateStudent(id, updatedStudent.getName(), updatedStudent.getEmail());
		
		if(rows > 0)
				return studentRepository.getReferenceById(id);
		
		return null;
	}
	
	//DELETE
	public String deleteStudent(Long id){
		int rows = studentRepository.deleteStudent(id);
		
		return rows > 0 ? "Student deleted successfully!" : "Student not found!";
	}
}
