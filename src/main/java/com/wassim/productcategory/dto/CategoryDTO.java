package com.wassim.productcategory.dto;


import java.util.UUID;

import jakarta.validation.constraints.Size;



public class CategoryDTO {
	
	private UUID Id;

    @Size(min = 2, max = 20, message = "Name must be between {min} and {max} characters")
    private String name;

    @Size(min = 2, max = 30, message = "Description must be between {min} and {max} characters")
    private String description;

    public CategoryDTO() {
    }

    public CategoryDTO(UUID id, String name, String description) {
        Id = id;
        this.name = name;
        this.description = description;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
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
