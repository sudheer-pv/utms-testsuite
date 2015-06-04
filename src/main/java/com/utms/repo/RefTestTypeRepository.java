package com.utms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utms.entity.RefTestType;

/**
 * Contains domain logic pertaining to ref test type.
 *
 * @author sowjanya
 * @version Revision: 1.0$ Date&Time:29 May, 2015,12:36:57 PM
 */
public interface RefTestTypeRepository extends JpaRepository<RefTestType, Integer> {

}
