package com.code.app.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AuthorDTO {
	@NotNull
	private String img;
	
	@NotNull(message = "Name is required.")
	@Size(max = 15, message = "Max 15 characteres.")
	private String name;
	
	@NotNull(message = "LastName is required.")
	@Size(max = 15, message = "Max 15 characteres.")
	private String lastName;
}
