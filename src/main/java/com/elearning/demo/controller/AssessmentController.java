package com.elearning.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.elearning.demo.model.Assessment;
import com.elearning.demo.model.course;
import com.elearning.demo.model.employee;
import com.elearning.demo.service.AssessmentService;

@RestController
public class AssessmentController {
	
	@Autowired
	AssessmentService service;
	@GetMapping("/ans")
	@CrossOrigin("http://localhost:4200")
	public List<Assessment> getanswers() {
		System.out.println("getmapping called in course");
		return service.findAll();
	}
	@PostMapping("/add")
	@CrossOrigin("http://localhost:4200")
	public Assessment addcourse(@RequestBody final Assessment assessment) throws Exception {

		
		return service.saveAssessment(assessment);
	}

}
