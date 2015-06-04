package com.utms.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.utms.entity.AutoTestStep;

public interface AutoTestStepRepository extends
		CrudRepository<AutoTestStep, Integer> {
	public List<AutoTestStep> findByAutoTestCaseId(Integer autotestCaseId);
	
	/*@Query("select u from AutoTestStep u  where u.AutoTestCase =:autotestCaseId ")
    public List<AutoTestStep> getAutoTestCaseId(@Param("autotestCaseId") Integer autotestCaseId);*/
}
