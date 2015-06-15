package com.utms.repo;

import org.springframework.data.repository.CrudRepository;

import com.utms.entity.TestStepResults;

public interface AutoTestStepResultsRepository extends CrudRepository<TestStepResults, Integer> {

}
