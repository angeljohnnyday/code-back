package com.code.app.service;

import com.code.app.dto.AuthorDTO;
import com.code.app.model.AuthorModel;

public interface AuthorService {
	AuthorModel create(AuthorDTO dto);
}
