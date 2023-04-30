package com.wassim.productcategory.services.Impl;

import java.util.List;
import java.util.UUID;

import com.wassim.productcategory.exceptions.AlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wassim.productcategory.dao.CategoryRepository;
import com.wassim.productcategory.dto.CategoryDTO;
import com.wassim.productcategory.dto.mapper.ICategoryMapper;
import com.wassim.productcategory.dto.mapper.IProductMapper;
import com.wassim.productcategory.entities.Category;
import com.wassim.productcategory.exceptions.ResourceNotFoundException;
import com.wassim.productcategory.services.ICategoryService;

@Service
public class CategoryServiceImp implements ICategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
    @Autowired
    private ICategoryMapper categoryMapper ;

    @Autowired
    private IProductMapper productMapper;

	@Override
	public CategoryDTO createCategory(CategoryDTO category) {
		//Check for the Name
		/*if(categoryRepository.existsByName(category.getName())) {
	            throw new AlreadyExistsException("The Category name "+ category.getName()+" Already exists!!!");
		 }*/

		categoryRepository.findByName(category.getName()).ifPresent(existingCat -> {
			throw new AlreadyExistsException("category with this name: "+category.getName() +" already exists!!");
		});


		return categoryMapper.toCategoryDTO(categoryRepository.save(categoryMapper.toCategory(category)));

	}

	@Override
	public CategoryDTO updateCategory(CategoryDTO category, UUID id) {
		Category findcategory = categoryRepository.findById(id)
                //check if the field is not empty
                .orElseThrow(() -> new ResourceNotFoundException("No Category found with the identifier "+id));

        //check if old name equals new name
		if (categoryRepository.findByName(category.getName()).isPresent()) {
			throw new AlreadyExistsException("Category with this name already exists: " + category.getName());
		}

        findcategory.setName(category.getName());
        findcategory.setDescription(category.getDescription());
        return categoryMapper.toCategoryDTO(categoryRepository.save(findcategory));
	}

	@Override
	public List<CategoryDTO> getAllCategories(int page, int size) {
		Pageable pageable= PageRequest.of(page, size);
		Page<Category> categories = categoryRepository.findAll(pageable);
		return categoryMapper.toCategoryDTOs(categories.toList());
	}

	@Override
	public CategoryDTO getCategoryById(UUID id) {
		
		Category category = categoryRepository.findById(id).orElseThrow(() -> new
                ResourceNotFoundException("No Category found with the identifier "+id));
        return categoryMapper.toCategoryDTO(category);
	}

	@Override
	public void deleteCategory(UUID id) {
		categoryRepository.findById(id).orElseThrow(() 
				-> new ResourceNotFoundException("No Category found with the identifier "+id));
        categoryRepository.deleteById(id);
		
	}
	
}
