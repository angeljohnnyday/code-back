package com.code.app.rest;

import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.code.app.dto.BlogDTO;
import com.code.app.model.BlogModel;
import com.code.app.service.BlogServiceImpl;

import jakarta.validation.Valid;

@CrossOrigin
@RestController()
@RequestMapping("/blog")
public class BlogRest {
	@Autowired private BlogServiceImpl blogService;
	
	@GetMapping("/")
	ResponseEntity<Map<String, Object>> finAll(@RequestParam int page, @RequestParam int size) {
		try {
			return new ResponseEntity<Map<String, Object>>(
				blogService.findAll(page, size), 
				HttpStatus.OK
			);
		} catch (Exception e) {
			return new ResponseEntity<>(
				null, 
				HttpStatus.NOT_FOUND
			);
		}
	}
	
	@GetMapping("/{blogId}")
	ResponseEntity<BlogModel> getById(@PathVariable UUID blogId) {
		try {
			return new ResponseEntity<BlogModel>(
				blogService.findById(blogId), 
				HttpStatus.OK
			);
		} catch (Exception e) {
			return new ResponseEntity<>(
				null, 
				HttpStatus.NOT_FOUND
			);
		}
	}
	
	@PostMapping("/")
	ResponseEntity<BlogModel> create(@Valid @RequestBody BlogDTO dto) {
		try {
			return new ResponseEntity<BlogModel>(
				blogService.create(dto), 
				HttpStatus.OK
			);
		} catch (Exception e) {
			return new ResponseEntity<>(
				null, 
				HttpStatus.INTERNAL_SERVER_ERROR
			);
		}
	}
	
	@PutMapping("/{blogId}")
	ResponseEntity<BlogModel> update(@Valid @PathVariable UUID blogId, @RequestBody BlogDTO dto) {
		try {
			return new ResponseEntity<BlogModel>(
				blogService.update(blogId, dto), 
				HttpStatus.OK
			);
		} catch (Exception e) {
			return new ResponseEntity<>(
				null, 
				HttpStatus.INTERNAL_SERVER_ERROR
			);
		}
	}
	
}
