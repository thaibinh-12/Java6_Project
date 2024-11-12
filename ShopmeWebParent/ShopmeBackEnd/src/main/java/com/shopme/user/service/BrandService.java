package com.shopme.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shopme.common.entity.Brand;
import com.shopme.user.jpa.BrandJPA;

@Service
public class BrandService {
	@Autowired
	private BrandJPA brandJPA;
	
	public Brand saveOrUpdateBrand(Brand brand) {
		Optional<Brand> extBrand = brandJPA.findById(brand.getId());
		
		if (extBrand.isPresent()) {
			Brand brand2 = extBrand.get();
			brand2.setName(brand.getName());
			
			return brandJPA.save(brand2);
		}else {
			return brandJPA.save(brand);
		}
	}
	
	public void deleteType(int id) {
		if (brandJPA.existsById(id)) {
			brandJPA.deleteById(id);
		}else {
			throw new IllegalArgumentException("type id: "+id+"error");
		}
	}

	public Optional<Brand> getBrandById(int id){
		return brandJPA.findById(id);
	}
	public List<Brand> getAllBrand(){
		return brandJPA.findAll();
	}
	public boolean typeExists(int id) {
		return brandJPA.existsById(id);
	}
}
