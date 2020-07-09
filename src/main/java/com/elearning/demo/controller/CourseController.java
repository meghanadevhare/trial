package com.elearning.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elearning.demo.model.Assessment;
import com.elearning.demo.model.course;
import com.elearning.demo.model.employee;
import com.elearning.demo.repository.AssessmentRepository;
import com.elearning.demo.service.CourseService;
import com.elearning.demo.service.RegistrationService;

@RestController
//@RequestMapping("/a")
public class CourseController {
	@Autowired
	CourseService service;
	@Autowired
	RegistrationService s;
	@Autowired
	AssessmentRepository a;

	@GetMapping("/courses")
	@CrossOrigin("http://localhost:4200")
	public List<course> getEmployee() {
		System.out.println("getmapping called in course");
		return service.findAll();
	}

	@GetMapping("/isvalid")
	public String isValidFacilitator() {
		employee emp;
		emp = s.lastEmployee();
		String role1 = emp.getRole();
		Assessment assessment ;
		assessment=a.findTopByOrderByQueidDesc();
		int marks=0;
		if(assessment.getQue1().equals("a"))
			marks+=1;
		if(assessment.getQue2().equals("a"))
			marks+=1;
		if(assessment.getQue3().equals("a"))
			marks+=1;
		
		
		if (role1.equals("facilitator") && marks>1)
		{
			
			return "valid";
		}
		emp.setRole("learner");
		s.saveEmployee(emp);
		return "invalid";
	}

	@PostMapping("/addcourse")
	@CrossOrigin("http://localhost:4200")
	public course addcourse(@RequestBody final course course1) throws Exception {

		employee emp;
		emp = s.lastEmployee();
		String tempTitle = course1.getCoursetitle();
		course course;
		course = service.findCourseByCoursetitle(tempTitle);
		if (course != null) {
			throw new Exception("This course already exist!");
		}
		System.out.println("calling add course");
		course1.setEmployee1(emp);

		return service.saveCourse(course1);
	}

}
