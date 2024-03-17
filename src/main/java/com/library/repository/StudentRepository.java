package com.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.library.entities.Student;


public interface StudentRepository extends JpaRepository<Student,Integer>
{
	List<Student> findAllByBranch(String branch);
	List<Student> findStudentByBranchAndCgpaGreaterThan(String branch,double cgpa);
	Student findStudentByEmailId(String emailId);
	
}
