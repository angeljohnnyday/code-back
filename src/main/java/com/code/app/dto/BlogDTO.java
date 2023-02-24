package com.code.app.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BlogDTO {
	@NotNull(message = "Title is required.")
	@Size(max = 70, message = "Max 70 characteres.")
	private String title;
	
	@NotNull
	private String img;
	
	@NotNull(message = "Body is required.")
	@Size(max = 10000, message = "Max 10,000 characteres.")
	private String body;
	
	@NotNull(message = "Author is required")
	private AuthorDTO author;
}
