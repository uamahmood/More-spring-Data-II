package com.umermahmood.ProductsAndCategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.umermahmood.ProductsAndCategories.models.Category;
import com.umermahmood.ProductsAndCategories.models.Product;

@Repository
public interface ProductRepo extends CrudRepository <Product, Long> {
	List<Product> findAll();
	List<Product> findByCategoriesNotContains(Category category);
}
