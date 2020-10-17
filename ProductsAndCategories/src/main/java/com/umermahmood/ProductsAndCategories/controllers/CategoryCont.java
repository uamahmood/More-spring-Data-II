package com.umermahmood.ProductsAndCategories.controllers;



import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.umermahmood.ProductsAndCategories.models.Category;
import com.umermahmood.ProductsAndCategories.services.ProdCatServ;

@Controller
public class CategoryCont {
	private final ProdCatServ prodCatServ;
	
	public CategoryCont(ProdCatServ prodCatServ) {
		this.prodCatServ = prodCatServ;
	}
	
	@GetMapping("/categories/new")
	public String newCatPage(Model model) {
		model.addAttribute("categoryObject", new Category());
		return "ProductsAndCategories/newcategory.jsp";
	}
	
	@PostMapping("/addcategory")
	public String addCategory(@Valid @ModelAttribute("categoryObject") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "/categories/new";
		}
		else {
			prodCatServ.addCat(category);
			return "redirect:/categories/new";
		}
	}
}
