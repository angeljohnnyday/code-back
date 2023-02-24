package com.code.app.service;

import java.util.Map;
import java.util.UUID;

import com.code.app.dto.BlogDTO;
import com.code.app.model.BlogModel;

public interface BlogService {
	Map<String, Object> findAll(int page, int size);
	BlogModel findById(UUID uuid);
	BlogModel create(BlogDTO dto);
	BlogModel update(UUID blogId, BlogDTO dto);
}
