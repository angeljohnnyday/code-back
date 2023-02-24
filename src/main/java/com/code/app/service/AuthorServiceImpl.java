package com.code.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.app.dto.AuthorDTO;
import com.code.app.model.AuthorModel;
import com.code.app.repository.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService {
	
	@Autowired AuthorRepository authorRepository;

	@Override
	public AuthorModel create(AuthorDTO dto) {
		AuthorModel model = new AuthorModel();
		model.setName(dto.getName());
		model.setLastName(dto.getLastName());
		model.setImg(dto.getImg());
		
		authorRepository.save(model);
		
		return model;
	}

}
