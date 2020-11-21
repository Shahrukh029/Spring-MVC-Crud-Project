package com.sevenmentor.spring.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sevenmentor.spring.mvc.dao.StudentDao;
import com.sevenmentor.spring.mvc.entity.Student;


@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDAO;
	
	@Override
	@Transactional
	public List<Student> getStudents() {
		return studentDAO.getStudents();
	}
	@Override
	@Transactional
	public void saveStudent(Student theStudent) {

		studentDAO.saveStudent(theStudent);
	}
	@Override
	@Transactional
	public Student getStudent(int theId) {
		
		return studentDAO.getStudent(theId);
	}
	@Override
	@Transactional
	public void deleteStudent(int theId) {
		
		studentDAO.deleteStudent(theId);
	}
	@Override
	@Transactional
	public Student getUserByName(int id) {
		Student Student=studentDAO.getUserByName(id);
		return Student;
	}
}


