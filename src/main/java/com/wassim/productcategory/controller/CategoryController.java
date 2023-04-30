package com.wassim.productcategory.controller;

import java.util.List;
import java.util.UUID;

import com.wassim.productcategory.exceptions.AlreadyExistsException;
import com.wassim.productcategory.exceptions.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wassim.productcategory.dto.CategoryDTO;
import com.wassim.productcategory.services.ICategoryService;

@RestController
@RequestMapping("/category/")
public class CategoryController {

    private final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private ICategoryService categoryService;

    @PostMapping("add")
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO category) {
        try {
            logger.info("Request for adding new category "+category);
            CategoryDTO savedCategory = categoryService.createCategory(category);
            return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
        } catch (AlreadyExistsException e) {
            logger.error("Error creating category: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("allCategories/{page}/{size}")
    public ResponseEntity<List<CategoryDTO>> getAllCategories(@PathVariable("page") int page,@PathVariable("size") int size) {
        try {
            logger.info("Request for getting all the category");
            List<CategoryDTO> categories = categoryService.getAllCategories(page, size);
            return new ResponseEntity<>(categories, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            logger.error("Error getting all categories: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("getone/{id}")
    public ResponseEntity<CategoryDTO> getUserById(@PathVariable("id") UUID id) {
        try {
            logger.info("Request for Category id");
            CategoryDTO category = categoryService.getCategoryById(id);
            return new ResponseEntity<>(category, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            logger.error("Error getting category by id: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable("id") UUID id,
                                                      @RequestBody CategoryDTO category) {
        try {
            logger.info("request for category: ",category," with id :", id);
            CategoryDTO updatedCategory = categoryService.updateCategory(category, id);
            return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            logger.error("Error updating category By Id: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (AlreadyExistsException e) {
            logger.error("Error Category Name already Exists: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);}
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Object> deleteCategory(@PathVariable("id") UUID id) {
        try {
            logger.info("Request for deleting contact");
            categoryService.deleteCategory(id);
            return new ResponseEntity<>("Category successfully deleted!", HttpStatus.NO_CONTENT);
        } catch (ResourceNotFoundException  e) {
            logger.error("Error deleting category: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
