package com.utms.repo;

import org.springframework.data.repository.CrudRepository;

import com.utms.entity.TestCaseResults;

public interface AutoTestCaseResultsRepository extends CrudRepository<TestCaseResults, Integer> {
	
	TestCaseResults findTestCaseResultsByIdAndExeRunId(Integer testCaseResultId, Integer exeRunId);

}
