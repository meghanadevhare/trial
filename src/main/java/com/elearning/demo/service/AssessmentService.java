package com.elearning.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elearning.demo.model.Assessment;
import com.elearning.demo.model.course;
import com.elearning.demo.model.employee;
import com.elearning.demo.repository.AssessmentRepository;

@Service
public class AssessmentService {
	@Autowired
	AssessmentRepository repo;
	public List<Assessment> findAll() {
		return (List<Assessment>) repo.findAll();
	}

	

	public Assessment saveAssessment(Assessment assessment) {
		return repo.save(assessment);
	}
	public Assessment lastAssessment()
	{
		return repo.findTopByOrderByQueidDesc();
	}


	


}
