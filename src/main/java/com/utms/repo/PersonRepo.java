package com.utms.repo;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.utms.entity.Person;
@Transactional
public interface PersonRepo extends CrudRepository<Person, Long> {
	
	Person findById(long id);

}
