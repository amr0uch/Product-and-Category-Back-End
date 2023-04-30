package com.wassim.productcategory.services.Impl;

import java.util.List;
import java.util.UUID;

import com.wassim.productcategory.dao.CategoryRepository;
import com.wassim.productcategory.dto.CategoryDTO;
import com.wassim.productcategory.dto.mapper.ICategoryMapper;
import com.wassim.productcategory.entities.Category;
import com.wassim.productcategory.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wassim.productcategory.dao.ProductRepository;
import com.wassim.productcategory.dto.ProductDTO;
import com.wassim.productcategory.dto.mapper.IProductMapper;
import com.wassim.productcategory.entities.Product;
import com.wassim.productcategory.exceptions.ResourceNotFoundException;
import com.wassim.productcategory.services.IProductService;

@Service
public class ProductServiceImp implements IProductService {

	@Autowired
    private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
    @Autowired
    private IProductMapper productMapper;

	@Autowired
	private ICategoryMapper categoryMapper;
	
    
    @Override
	public ProductDTO createProduct(ProductDTO product) {
		if(categoryRepository.existsById(product.getCategories().getId())) {
			return productMapper.toProductDTO(productRepository.save(productMapper.toProduct(product)));
		}else {
			throw new ResourceNotFoundException("Category not exists");
		}

	}
	@Override
	public ProductDTO updateProduct(ProductDTO productDTO, UUID id) {
		Product findProduct = productRepository.findById(id)
                //start the exception when the product is not found
                .orElseThrow(() -> new ResourceNotFoundException("No product found with the identifier "+id));
        //change old values to new values
		findProduct.setName(productDTO.getName());
		findProduct.setDescription(productDTO.getDescription());
		findProduct.setSellPrice(productDTO.getSellPrice());
		findProduct.setBuyPrice(productDTO.getBuyPrice());
		findProduct.setStock(productDTO.getStock());
		findProduct.setCategories(categoryMapper.toCategory(productDTO.getCategories()));
        return productMapper.toProductDTO(productRepository.save(findProduct));
	}
	@Override
	public List<ProductDTO> getAllProduct() {

		List<Product> products = productRepository.findAll();
		return productMapper.toProductDTOs(products);
	}
	@Override
	public ProductDTO getProductById(UUID id) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found."));
		return productMapper.toProductDTO(product);
	}
	@Override
	public void deleteProduct(UUID id) {
		productRepository.findById(id).orElseThrow(() 
				-> new ResourceNotFoundException("No product found with the identifier "+id));
        productRepository.deleteById(id);
		
	}
    
    
}
