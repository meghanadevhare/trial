package com.elearning.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elearning.demo.model.Assessment;
import com.elearning.demo.model.employee;

public interface AssessmentRepository extends JpaRepository<Assessment, Integer> {
	public Assessment findTopByOrderByQueidDesc();
}
