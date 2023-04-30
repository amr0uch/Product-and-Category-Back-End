package com.wassim.productcategory.dto.mapper;

import java.util.List;

import com.wassim.productcategory.dto.ProductDTO;
import com.wassim.productcategory.entities.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IProductMapper {

    ProductDTO toProductDTO(Product product);
    Product toProduct(ProductDTO productDTO);
    List<ProductDTO> toProductDTOs(List<Product> products);
    List<Product> toProducts(List<ProductDTO> productDTOs);
}
