package com.prateek.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prateek.exception.StudentException;
import com.prateek.model.Student;
import com.prateek.repository.StudentRepo;


@Service
public class StudentDaoImpl implements StudentService{
    @Autowired
	private StudentRepo sRepo;
	
	@Override
	public Student registerStudent(Student s) {
		// TODO Auto-generated method stub
		Student savedStudent = sRepo.save(s);
		
		return savedStudent;
	}

	@Override
	public Student getStudentById(Integer roll) throws StudentException {
		// TODO Auto-generated method stub
		Optional<Student> opt = sRepo.findById(roll);
		
		return opt.orElseThrow(() -> new StudentException("No Sttudent present with this "+roll));
		
	
		
	}
	
	@Override
	public List<Student> getAllStudents()throws StudentException{
		
		List<Student> res = sRepo.findAll();
		
		if(res.size()==0) {
			throw new StudentException("No student present!");
		}else {
			return res;
		}
		
	}

	@Override
	public Student deleteStudentByRoll(Integer roll) throws StudentException {
		// TODO Auto-generated method stub
	   Optional<Student> opt = sRepo.findById(roll);
	   
	   if(opt.isPresent()) {
		   
		   Student st = opt.get();
		   sRepo.delete(st);
		   
		   return st;
		   
	   }else {
		   throw new StudentException("No Student present with roll "+roll);
	   }
	}

	@Override
	public Student updateStudentDetails(Student s) throws StudentException {
		// TODO Auto-generated method stub
      Optional<Student> opt = sRepo.findById(s.getId());
	
	if(opt.isPresent()) {
		
		Student updatedStudent = sRepo.save(s);
		return updatedStudent;
	}
	else {
		throw new StudentException("No such student is present");
	}
	}

	@Override
	public Student updateStudentMarks(Integer roll, Integer graceMarks) throws StudentException {
		// TODO Auto-generated method stub
		
		Student eStudent = sRepo.findById(roll).orElseThrow(()->new StudentException("No Student exists with roll "+roll));
		
		eStudent.setMarks(eStudent.getMarks()+graceMarks);
		
		return sRepo.save(eStudent);
		
		
	}

	

}
