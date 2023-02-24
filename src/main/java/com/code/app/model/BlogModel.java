package com.code.app.model;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "blogs")
public class BlogModel {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID blogId;
	
	@Column( length = 70 )
	private String title;
	
	@Lob
	private String img;
	
	@Lob
	@Column( length = 10000 )
	private String body;
	
	@ManyToOne()
    @JoinColumn(name="authorId")
	private AuthorModel author;
	
	@Temporal(value=TemporalType.DATE)
	private Date createAt;
	
	@Temporal(value=TemporalType.DATE)
	private Date updateAt;
}
