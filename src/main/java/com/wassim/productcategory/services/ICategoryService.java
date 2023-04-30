package com.wassim.productcategory.services;

import java.util.List;
import java.util.UUID;

import com.wassim.productcategory.dto.CategoryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoryService {
	

    //create new category
    public CategoryDTO createCategory(CategoryDTO category);

    //update the category
    public CategoryDTO updateCategory(CategoryDTO category, UUID id);

    //select all categories
    public List<CategoryDTO> getAllCategories(int page, int size);

    //select category by id
    public CategoryDTO getCategoryById(UUID id);

    //delete the category
    public void deleteCategory(UUID id);
}
