package com.wassim.productcategory.entities;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
public class Category {

	@Id @GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "uuid2" )
	@Column(nullable = false, unique = true)
	private UUID id;
	
	@Column(columnDefinition = "varchar(20)", nullable = false)
	private String name;
	
	@Column(columnDefinition = "varchar(30)", nullable = false)
	private String description;

	public Category() {
	}

	public Category(UUID id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
