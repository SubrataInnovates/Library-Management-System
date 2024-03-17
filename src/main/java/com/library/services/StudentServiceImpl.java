package com.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entities.Student;
import com.library.exception.ServiceException;
import com.library.repository.StudentRepository;


@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public String addStudent(Student student) {
        try {
            if (student == null) {
                throw new IllegalArgumentException("Student object is null");
            }
            studentRepository.save(student);
            return "Student has been added";
        } catch (Exception e) {
            throw new ServiceException("Failed to add student", e);
        }
    }

    @Override
    public List<Student> findStudentByBranchAndCgpaGreaterThan(String branch, double cgpa) {
        try {
            if (branch == null || branch.isEmpty() || cgpa < 0) {
                throw new IllegalArgumentException("Invalid input parameters");
            }
            return studentRepository.findStudentByBranchAndCgpaGreaterThan(branch, cgpa);
        } catch (Exception e) {
            throw new ServiceException("Failed to retrieve students by branch and CGPA", e);
        }
    }

    @Override
    public List<Student> findAllByBranch(String branch) {
        try {
            if (branch == null || branch.isEmpty()) {
                throw new IllegalArgumentException("Branch name is null or empty");
            }
            return studentRepository.findAllByBranch(branch);
        } catch (Exception e) {
            throw new ServiceException("Failed to retrieve students by branch", e);
        }
    }

    @Override
    public Student findStudentByEmailId(String emailId) {
        try {
            if (emailId == null || emailId.isEmpty()) {
                throw new IllegalArgumentException("Email ID is null or empty");
            }
            return studentRepository.findStudentByEmailId(emailId);
        } catch (Exception e) {
            throw new ServiceException("Failed to retrieve student by email ID", e);
        }
    }
}