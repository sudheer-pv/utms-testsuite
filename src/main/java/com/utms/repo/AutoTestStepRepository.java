package com.utms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utms.entity.AutoTestStep;

// TODO: Auto-generated Javadoc
/**
 * Contains domain logic pertaining to auto test step.
 *
 * @author Rajasekhar
 * @version Revision: 1.0$ Date&Time:29 May, 2015,12:37:23 PM
 */
public interface AutoTestStepRepository extends
		JpaRepository<AutoTestStep, Integer> {
	
}
