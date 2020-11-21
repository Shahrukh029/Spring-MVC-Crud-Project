package com.sevenmentor.spring.mvc.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sevenmentor.spring.mvc.dao.StudentDao;
import com.sevenmentor.spring.mvc.entity.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	// need to inject the session factory
		@Autowired
		private SessionFactory sessionFactory;
				
		@Override
		public List<Student> getStudents() {
			
			// get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
					
			// create a query
			Query<Student> theQuery = 
					currentSession.createQuery("from Student", Student.class);
			
			// execute query and get result list
			List<Student> Students = theQuery.getResultList();
					
			// return the results		
			return Students;
		}
		@Override
		public void saveStudent(Student theStudent) {

			// get current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
			
			// save the Student ... finally LOL
			currentSession.saveOrUpdate(theStudent);
			
		}
		@Override
		public Student getStudent(int theId) {

			// get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
			
			// now retrieve/read from database using the primary key
			Student theStudent = currentSession.get(Student.class, theId);
			
			return theStudent;
		}
		@Override
		public void deleteStudent(int theId) {

			// get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
			
			// delete object with primary key
			Query theQuery = 
					currentSession.createQuery("delete from Student where id=:StudentId");
			theQuery.setParameter("StudentId", theId);
			
			theQuery.executeUpdate();		
		}
		@Override
		public Student getUserByName(int id) {
			Session session=sessionFactory.getCurrentSession();
			
			Student Student=session.get(Student.class, id);
			
			return Student;
		}



}
