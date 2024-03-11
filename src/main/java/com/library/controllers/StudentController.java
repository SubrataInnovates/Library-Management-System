package com.library.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.entities.Student;
import com.library.services.StudentService;



@RestController
@RequestMapping("/student")

public class StudentController 
{
	@Autowired
	private StudentService studentService;

	private static final Logger log = LoggerFactory.getLogger(StudentController.class);
	
	@PostMapping("/add")
	public String addstudent(@RequestBody Student student)
	{
		String addStudent = studentService.addStudent(student);
		log.info("Student added :{}"+addStudent);
		return addStudent;
	}

}
