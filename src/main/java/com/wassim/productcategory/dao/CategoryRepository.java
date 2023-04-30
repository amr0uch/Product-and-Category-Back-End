package com.wassim.productcategory.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

import com.wassim.productcategory.entities.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {


    Optional<Category> findByName(String name);

  //  @Query("select count(C)>0 from category C where C.name = :name")
    //public boolean existsByName(@Param("name") String name);
}
