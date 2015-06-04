package com.utms.repo;

import org.springframework.data.repository.CrudRepository;

import com.utms.entity.ExeConfig;

public interface ExeConfigRepository extends CrudRepository<ExeConfig, Integer> {
	public ExeConfig findById(Integer projectId);
}
