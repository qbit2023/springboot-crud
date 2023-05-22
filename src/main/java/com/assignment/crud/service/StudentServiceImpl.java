package com.assignment.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.crud.exception.ResourceNotFoundException;
import com.assignment.crud.model.Student;
import com.assignment.crud.repository.StudentRepository;



@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studRepository;
	
	
	@Override
	public Student createStudent(Student stud) {
		return studRepository.save(stud);
	}

	@Override
	public Student updateStudent(Student student) {
		
		Optional<Student> optionalStudent = studRepository.findById(student.getId());
        if (optionalStudent.isPresent()) {
            Student studentUpdated = optionalStudent.get();
            studentUpdated.setFirstName(student.getFirstName());
            studentUpdated.setLastName(student.getLastName());
            studentUpdated.setEmail(student.getEmail());
            studRepository.save(studentUpdated);
            return studentUpdated;
		}else {
			throw new ResourceNotFoundException("Student not found: " + student);
		}	
	}

	@Override
	public Student getStudentById(long studId) {
		Optional<Student> studentOptional = studRepository.findById(studId); //handle null
		
		if(studentOptional.isPresent()) {
			return studentOptional.get();
		}else {
			throw new ResourceNotFoundException("Student not found with ID: " + studId);
		}
	}

	@Override
	public List<Student> getAllStudents() {
		return studRepository.findAll();
	}

	@Override
	public void deleteStudent(long studId) {
		 Optional<Student> optionalStudent = studRepository.findById(studId);
	        if (optionalStudent.isPresent()) {
	            studRepository.deleteById(studId);
	            
	        } else {
	            throw new ResourceNotFoundException("Student not found with ID: " + studId);
	        }
	    }
	

}
