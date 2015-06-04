package com.utms.repo;

import org.springframework.data.repository.CrudRepository;

import com.utms.entity.AutoTestCase;

public interface AutoTestCaseRepository extends CrudRepository<AutoTestCase, Integer> {
	
	public AutoTestCase findByTestCaseId(Integer testCaseId);
}
