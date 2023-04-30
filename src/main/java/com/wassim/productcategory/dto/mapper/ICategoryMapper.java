package com.wassim.productcategory.dto.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import com.wassim.productcategory.dto.CategoryDTO;
import com.wassim.productcategory.entities.Category;

@Mapper(componentModel = "spring")
public interface ICategoryMapper {
    CategoryDTO toCategoryDTO(Category category);
    Category toCategory(CategoryDTO categoryDTO);
    List<CategoryDTO> toCategoryDTOs(List<Category> categories);
}	
