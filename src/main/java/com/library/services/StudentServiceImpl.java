package com.library.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entities.Student;
import com.library.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService
{
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public String addStudent(Student student) 
	{
		studentRepository.save(student);
		
		return "Student has been added";
	}
	
	
	

}
