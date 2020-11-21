package com.sevenmentor.spring.mvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sevenmentor.spring.mvc.entity.Student;


public interface StudentService {
	public List<Student> getStudents();

	void saveStudent(Student theStudent);
	public Student getStudent(int theId);
	public void deleteStudent(int theId);

	public Student getUserByName(int id);
	

}
