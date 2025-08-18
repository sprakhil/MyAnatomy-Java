package com.jpql.studentcrud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jpql.studentcrud.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
	//READ -> Get all the students
	@Query("SELECT s FROM Student s")
	List<Student> getAllStudents();
	
	//READ -> Get by ID
	@Query("SELECT s FROM Student s WHERE s.id=:id")
	Student getStudentById(@Param("id") Long id);
	
	//UPDATE -> JPQL Update
	@Modifying
	@Query("UPDATE Student s SET s.name = :name, s.email = :email WHERE s.id = :id")
	int updateStudent(@Param("id") Long id, 
			@Param("name") String name,
			@Param("email") String email);
	
	//DELETE -> JPQL Delete
	@Modifying
	@Query("DELETE FROM Student s WHERE s.id =:id")
	int deleteStudent(@Param("id") Long id);
}
