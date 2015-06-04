package com.utms.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.utms.entity.RefKeyword;


public interface RefKewordRepository extends CrudRepository<RefKeyword, Integer> {

	public List<RefKeyword> findByProjectId(Integer projectID);
	public RefKeyword findById(Integer id);

}
