package com.assignment.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.crud.model.Student;
import com.assignment.crud.service.StudentService;

@RestController                    
public class StudentController {


	@Autowired
	private StudentService studentService;
	
	//get all
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents(){
		return ResponseEntity.ok().body(studentService.getAllStudents());
	}
	
	//get by id
	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable long id){
		return ResponseEntity.ok().body(studentService.getStudentById(id));
	}
	
	//create
	@PostMapping("/create/student")
	public ResponseEntity<Student> createStudent(@RequestBody Student student){
		return ResponseEntity.ok().body(studentService.createStudent(student));
	}
	
	//update
	@PutMapping("/update/student/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable long id, @RequestBody Student student){
		student.setId(id);
		return ResponseEntity.ok().body(studentService.updateStudent(student));
	}

	//delete
	@DeleteMapping("/delete/student/{studId}")
	public HttpStatus deleteStudent(@PathVariable long studId){
		System.out.println(studId);
		studentService.deleteStudent(studId);
		return HttpStatus.OK;
	}
	
}
