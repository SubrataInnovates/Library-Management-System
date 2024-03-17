package com.library.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	    public ResponseEntity<String> addStudent(@RequestBody Student student) {
	        try {
	            String addStudentResult = studentService.addStudent(student);
	            log.info("Student added: {}", addStudentResult);
	            return ResponseEntity.ok(addStudentResult);
	        } catch (Exception e) {
	            log.error("An error occurred while adding student: {}", e.getMessage());
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while adding student");
	        }
	    }
	@GetMapping("/getStudentByBranchAndCGPA")
    public ResponseEntity<List<Student>> getStudentByBranchAndCGPA(@RequestParam("branch") String branch, @RequestParam("cgpa") double cgpa) {
        try {
            List<Student> students = studentService.findStudentByBranchAndCgpaGreaterThan(branch, cgpa);
            return ResponseEntity.ok(students);
        } catch (Exception e) {
           
            log.error("An error occurred while retrieving students by branch and CGPA: {}", e.getMessage());
           
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
	}
	@GetMapping("/getStudenyByBranch")
	public ResponseEntity<List<Student>> findStudentByBranch(@RequestParam("branch") String branch)
	{
		try
		{
			List<Student> students = studentService.findAllByBranch(branch);
			return ResponseEntity.ok(students);
		} 
		catch (Exception e) {
			log.error("An error occurred while retrieving students by branch and CGPA: {}", e.getMessage());
	           
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	@GetMapping("/getStudenyByEmail")
	public ResponseEntity<Student> findStudentByEmail(@RequestParam("emailId") String emailId)
	{
		try
		{
			Student student = studentService.findStudentByEmailId(emailId);
			return ResponseEntity.ok(student);
		} 
		catch (Exception e) {
			log.error("An error occurred while retrieving students by branch and CGPA: {}", e.getMessage());
	           
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}
