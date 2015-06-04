package com.utms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utms.entity.RefTestPriority;

/**
 * Contains domain logic pertaining to ref test priority.
 *
 * @author sowjanya
 * @version Revision: 1.0$ Date&Time:29 May, 2015,12:36:50 PM
 */
public interface RefTestPriorityRepository extends JpaRepository<RefTestPriority, Integer> {

}
