package com.utms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utms.entity.TestCase;

/**
 * Contains domain logic pertaining to testcase.
 *
 * @author sowjanya
 * @version Revision: 1.0$ Date&Time:29 May, 2015,12:37:11 PM
 */
public interface TestcaseRepository extends JpaRepository<TestCase, Integer> {

}
