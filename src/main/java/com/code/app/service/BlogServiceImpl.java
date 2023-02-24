package com.code.app.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.code.app.dto.BlogDTO;
import com.code.app.model.BlogModel;
import com.code.app.repository.BlogRepository;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private AuthorServiceImpl authorServiceImpl;
	@Autowired
	private BlogRepository blogRepository;

	@Override
	public Map<String, Object> findAll(int page, int size) {
		Page<BlogModel> result = blogRepository.findAll(PageRequest.of(page, size));

		Map<String, Object> response = new HashMap<>();
		response.put("list", result.getContent());
		response.put("currentPage", result.getNumber());
		response.put("totalItems", result.getTotalElements());
		response.put("totalPages", result.getTotalPages());

		return response;
	}

	@Override
	public BlogModel findById(UUID blogID) {
		Optional<BlogModel> blog = blogRepository.findById(blogID);
		if (!blog.isEmpty())return blog.get();

		return null;
	}

	@Override
	public BlogModel create(BlogDTO dto) {
		BlogModel model = new BlogModel();
		model.setTitle(dto.getTitle());
		model.setBody(dto.getBody());
		model.setImg(dto.getImg());
		model.setCreateAt(new Date());
		model.setAuthor(authorServiceImpl.create(dto.getAuthor()));

		blogRepository.save(model);

		return model;
	}

	@Override
	public BlogModel update(UUID blogId, BlogDTO dto) {
		BlogModel model = this.findById(blogId);

		model.setTitle(dto.getTitle());
		model.setBody(dto.getBody());
		model.setUpdateAt(new Date());

		blogRepository.save(model);

		return model;
	}

}
