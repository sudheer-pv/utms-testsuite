package com.utms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utms.entity.TestStep;

// TODO: Auto-generated Javadoc
/**
 * Contains domain logic pertaining to test step.
 *
 * @author sowjanya
 * @version Revision: 1.0$ Date&Time:29 May, 2015,12:37:23 PM
 */
public interface TestStepRepository extends JpaRepository<TestStep, Integer> {

    /**
     * Find by test case id.
     *
     * @param testCaseId the test case id
     * @return the list
     */
    public List<TestStep> findByTestCaseId(Integer testCaseId);
    
}
