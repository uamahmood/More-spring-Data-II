package com.umermahmood.ProductsAndCategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.umermahmood.ProductsAndCategories.models.Category;
import com.umermahmood.ProductsAndCategories.models.CategoryProduct;
import com.umermahmood.ProductsAndCategories.models.Product;
import com.umermahmood.ProductsAndCategories.repositories.CategoryProductRepo;
import com.umermahmood.ProductsAndCategories.repositories.CategoryRepo;
import com.umermahmood.ProductsAndCategories.repositories.ProductRepo;

@Service
public class ProdCatServ {
	private final ProductRepo productRepo;
	private final CategoryRepo categoryRepo;
	private final CategoryProductRepo categoryProductRepo;
	
	public ProdCatServ(ProductRepo productRepo, CategoryRepo categoryRepo, CategoryProductRepo categoryProductRepo) {
		this.productRepo = productRepo;
		this.categoryRepo = categoryRepo;
		this.categoryProductRepo = categoryProductRepo;
	}
	
	//Product
	public void addProd(Product product) {
		productRepo.save(product);
	}
	
	public void setCat(Category category) {
		
	}
	
	public void addCatToProduct(CategoryProduct categoryProduct) {
		categoryProductRepo.save(categoryProduct);
	}
	
	public Product singleProd(Long id) {
		Optional<Product> product = productRepo.findById(id);
		if(product.isPresent()) {
			return product.get();
		}
		else {
			return null;
		}
	}
	
	public Iterable<Product> availableProductsForCategory(Category category) {
		return productRepo.findByCategoriesNotContains(category);
	}
	
	//Category
	public void addCat(Category category) {
		categoryRepo.save(category);
	}
	
	public List<Category> getCatAll() {
		return categoryRepo.findAll();
	}
	
    public List<Category> availableCategoriesForProduct(Product product) {
        return categoryRepo.findByProductsNotContains(product);  
    }
    
	public void addProdToCategory(CategoryProduct categoryProduct) {
		categoryProductRepo.save(categoryProduct);
	}
    
	public Category singleCat(Long id) {
		Optional<Category> category = categoryRepo.findById(id);
		if(category.isPresent()) {
			return category.get();
		}
		else {
			return null;
		}
	}
}
