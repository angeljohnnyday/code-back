package com.code.app.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.code.app.model.BlogModel;

public interface BlogRepository extends CrudRepository<BlogModel, UUID> {
	Page<BlogModel> findAll(Pageable pageable);
}
