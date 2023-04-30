package com.wassim.productcategory.dto;

import java.util.UUID;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



public class ProductDTO {

	
	private UUID Id;

    @Size(min = 2, max = 20, message = "Name must be between {min} and {max} characters")
    private String name;

    @Size(min = 2, max = 30, message = "Description must be between {min} and {max} characters")
    private String description;

    private double sellPrice;

    private double buyPrice;

    private Integer stock;

    private CategoryDTO categories;

    public ProductDTO() {
    }

    public ProductDTO(UUID id, String name, String description, double sellPrice, double buyPrice, Integer stock, CategoryDTO categories) {
        Id = id;
        this.name = name;
        this.description = description;
        this.sellPrice = sellPrice;
        this.buyPrice = buyPrice;
        this.stock = stock;
        this.categories = categories;
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

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public CategoryDTO getCategories() {
        return categories;
    }

    public void setCategories(CategoryDTO categories) {
        this.categories = categories;
    }
}
