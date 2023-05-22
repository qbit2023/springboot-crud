package com.assignment.crud.service;

import java.util.List;

import com.assignment.crud.model.Student;

public interface StudentService {

	Student createStudent(Student stud);

	Student updateStudent(Student stud);

	Student getStudentById(long studId);
	
	List<Student> getAllStudents();

	
	void deleteStudent(long id);
	
}
