package com.shopme.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopme.common.entity.Brand;
import com.shopme.common.entity.Product;
import com.shopme.user.jpa.BrandJPA;
import com.shopme.user.jpa.ProductJPA;

@Controller
@RequestMapping("/conan")
public class ProductController {
	@Autowired
	ProductJPA productJPA;

	@Autowired
	BrandJPA brandJPA;

	@RequestMapping("/product")
	public String getIndex(Model model) {
		List<Brand> brands = brandJPA.findAll();

		Map<String, List<Product>> brandProductMap = new HashMap<>();

		for (Brand brand : brands) {
			List<Product> products = productJPA.findByBrand(brand);
			 brandProductMap.put(brand.getName(), products);

		}
		model.addAttribute("brands", brands);
		model.addAttribute("brandProductMap", brandProductMap);
//		model.addAttribute("productCountMap", productCountMap);
		return "user/product";
	}
}
