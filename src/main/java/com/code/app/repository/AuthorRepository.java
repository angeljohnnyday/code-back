package com.code.app.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.code.app.model.AuthorModel;

public interface AuthorRepository extends CrudRepository<AuthorModel, UUID>{

}
