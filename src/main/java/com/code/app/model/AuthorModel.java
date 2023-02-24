package com.code.app.model;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "authors")
public class AuthorModel {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID authorId;
	
	@Lob
	private String img;
	
	@Column( length = 15 )
	private String name;

	@Column( length = 15 )
	private String lastName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "author")
    private List<BlogModel> blogs;
}
