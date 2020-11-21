package com.sevenmentor.spring.mvc.dao;

import java.util.List;

import com.sevenmentor.spring.mvc.entity.Student;




public interface StudentDao {
	public List<Student> getStudents();

	void saveStudent(Student theStudent);
	public Student getStudent(int theId);
	public void deleteStudent(int theId);

	public Student getUserByName(int id);
	

}
