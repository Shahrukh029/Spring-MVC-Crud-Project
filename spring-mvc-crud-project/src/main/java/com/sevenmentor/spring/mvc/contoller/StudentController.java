package com.sevenmentor.spring.mvc.contoller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sevenmentor.spring.mvc.entity.Student;
import com.sevenmentor.spring.mvc.service.StudentService;



@Controller
@RequestMapping("/student")
public class StudentController {

	// need to inject our Student service
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/list")
	public String listStudents(Model theModel) {
		
		// get Students from the service
		List<Student> theStudents = studentService.getStudents();
				
		// add the Students to the model
		theModel.addAttribute("students", theStudents);
		
		return "student-list";
	}
	
	@GetMapping("/showAddForm")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Student theStudent = new Student();
		
		theModel.addAttribute("student", theStudent);
		
		return "student-form";
	}
	
	@PostMapping("/saveStudent")
	public String saveStudent(@Valid @ModelAttribute("student") Student theStudent, BindingResult result) {
		
		if(result.hasErrors())
		{
			return "student-form";
		}
		// save the Student using our service
		studentService.saveStudent(theStudent);	
		
		return "redirect:/student/list";
	}
	
	@GetMapping("/showUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int theId,
									Model theModel) {
		
		// get the Student from our service
		Student theStudent = studentService.getStudent(theId);	
		
		// set Student as a model attribute to pre-populate the form
		theModel.addAttribute("student", theStudent);
		
		// send over to our form		
		return "student-form";
	}
	
	
	
	@GetMapping("/delete")
	public String deleteStudent(@RequestParam("studentId") int theId) {
		
		// delete the Student
		studentService.deleteStudent(theId);
		
		return "redirect:/student/list";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		
		
		StringTrimmerEditor editor=new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, editor);
	}

}
