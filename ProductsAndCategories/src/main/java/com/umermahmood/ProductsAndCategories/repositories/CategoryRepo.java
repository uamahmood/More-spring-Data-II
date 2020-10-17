package com.umermahmood.ProductsAndCategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.umermahmood.ProductsAndCategories.models.Category;
import com.umermahmood.ProductsAndCategories.models.Product;

@Repository
public interface CategoryRepo extends CrudRepository <Category, Long> {
	List<Category> findAll();
    List<Category> findByProductsNotContains(Product product);
}
