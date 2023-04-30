package com.wassim.productcategory.entities;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Product {
	
	@Id @GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "uuid2" )
	@Column(nullable = false, unique = true)
	private UUID id;
	
	@Column(columnDefinition ="varchar(20)", nullable = false)
	private String name;
	
	@Column(columnDefinition ="varchar(30)", nullable = false)
	private String description;
	
	@Column(nullable = false)
	private double sellPrice;
	
	@Column(nullable = false)
	private double buyPrice;
	
	@Column(nullable = false)
	private Integer stock;
	
	@ManyToOne
	private Category categories;

	public Product() {
	}

	public Product(UUID id, String name, String description, double sellPrice, double buyPrice, Integer stock, Category categories) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.sellPrice = sellPrice;
		this.buyPrice = buyPrice;
		this.stock = stock;
		this.categories = categories;
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

	public Category getCategories() {
		return categories;
	}

	public void setCategories(Category categories) {
		this.categories = categories;
	}
}
