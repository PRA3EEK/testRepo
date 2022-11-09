package com.prateek.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prateek.exception.StudentException;
import com.prateek.model.Student;
import com.prateek.services.StudentService;

@RestController
@RequestMapping("/studentApp")
public class StudentController {

	@Autowired
	private StudentService sService;
	
	@PostMapping("/student")
	public ResponseEntity<Student> addStudent(@RequestBody Student s){
		
		
		Student sS = sService.registerStudent(s);
		
		return new ResponseEntity<Student>(sS, HttpStatus.OK);
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") int id) throws StudentException{
		
		Student resS = sService.getStudentById(id);
		
		return new ResponseEntity<Student>(resS, HttpStatus.OK);
		
	}
	
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudentHandler() throws StudentException{
		
		List<Student> students = sService.getAllStudents();
		
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}
	
	@DeleteMapping("/students/{roll}")
	public ResponseEntity<Student> deleteStudentByIdHandler(@PathVariable("roll") Integer roll) throws StudentException{
		
		Student st = sService.deleteStudentByRoll(roll);
		
		return new ResponseEntity<Student>(st, HttpStatus.OK);
	}
	
	
	@PutMapping("/student")
	public ResponseEntity<Student> updateStudentHandler(@RequestBody Student student) throws StudentException{
		
		Student passedStudent = sService.updateStudentDetails(student);
		
		return new ResponseEntity<Student>(passedStudent, HttpStatus.ACCEPTED);
		
	}
	
	
	@PutMapping("/student/{roll}")
	public ResponseEntity<Student> updateStudentMarksHandler(@PathVariable("roll") Integer roll, @RequestParam(value = "gmarks", required = false) Integer gmarks) throws StudentException{
		
		Student updatedStudent = sService.updateStudentMarks(roll, gmarks);
		
		return new ResponseEntity<Student>(updatedStudent, HttpStatus.ACCEPTED);
		
	}
	
	
}
