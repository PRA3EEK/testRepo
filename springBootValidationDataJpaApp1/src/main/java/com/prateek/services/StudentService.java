package com.prateek.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.prateek.exception.StudentException;
import com.prateek.model.Student;

public interface StudentService {

	
	public Student registerStudent(Student s);
	
	public Student getStudentById(Integer roll) throws StudentException;
	
	
	public List<Student> getAllStudents()throws StudentException;
	
	public Student deleteStudentByRoll(Integer roll) throws StudentException;

    public Student updateStudentDetails(Student s) throws StudentException;

    public Student updateStudentMarks(Integer roll, Integer graceMarks) throws StudentException;

}
