package com.library.services;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.library.entities.Student;


public interface StudentService
{
	String addStudent(Student student);
	List<Student> findStudentByBranchAndCgpaGreaterThan(String branch,double cgpa);
	List<Student> findAllByBranch(String branch);
	Student findStudentByEmailId(String emailId);

}
