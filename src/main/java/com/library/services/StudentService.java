package com.library.services;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.library.entities.Student;


public interface StudentService
{
	String addStudent(Student student);

}
