package com.wassim.productcategory.services;

import java.util.List;
import java.util.UUID;

import com.wassim.productcategory.dto.ProductDTO;

public interface IProductService {
    //create new product
    public ProductDTO createProduct(ProductDTO product);

    //update the product
    public ProductDTO updateProduct(ProductDTO product, UUID id);

    //select all products
    public List<ProductDTO> getAllProduct();

    //select product by id
    public ProductDTO getProductById(UUID id);

    //delete the product
    public void deleteProduct(UUID id);

}
