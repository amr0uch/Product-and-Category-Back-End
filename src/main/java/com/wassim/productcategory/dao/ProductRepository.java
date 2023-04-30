package com.wassim.productcategory.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wassim.productcategory.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

}
