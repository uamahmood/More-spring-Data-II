package com.umermahmood.ProductsAndCategories.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.umermahmood.ProductsAndCategories.models.CategoryProduct;

@Repository
public interface CategoryProductRepo extends CrudRepository <CategoryProduct, Long> {
}
