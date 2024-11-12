package com.shopme.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopme.common.entity.Variant;
import com.shopme.user.jpa.VariantJPA;

@Service
public class VariantService {
	@Autowired
	private VariantJPA variantJPA;
	
	public Variant saveOrUpdateVariant(Variant variant) {
		Optional<Variant> extVariant = variantJPA.findById(variant.getId());
		
		if (extVariant.isPresent()) {
			Variant variant2 = extVariant.get();
			
			variant2.setSize(variant.getSize());
			variant2.setColor(variant.getColor());
			variant2.setProduct(variant.getProduct());
			variant2.setPrice(variant.getPrice());
			variant2.setQuantity(variant.getQuantity());
			
			return variantJPA.save(variant2);
		}else {
			return variantJPA.save(variant);
		}
				
	}
	
	public void deleteVariant(int id) {
		if (variantJPA.existsById(id)) {
			variantJPA.deleteById(id);
		}else {
			throw new IllegalArgumentException("variant id: "+id+"error");
		}
	}
	
	public Optional<Variant> getVariantById(int id){
		return variantJPA.findById(id);
	}
	
	public List<Variant> getAllVariant(int id){
		return variantJPA.findAll();
	}
	
	public boolean variantExists(int id) {
		return variantJPA.existsById(id);
	}
}
