package com.shopme.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopme.common.entity.Discount;
import com.shopme.common.entity.Product;
import com.shopme.user.jpa.DiscountJPA;
import com.shopme.user.jpa.ProductJPA;

@Service
public class DiscountService {
	@Autowired
	private DiscountJPA discountJPA;
	
	public Discount saveOrUpdateDiscount(Discount discount) {
		Optional<Discount> extDiscount = discountJPA.findById(discount.getId());
		if (extDiscount.isPresent()) {
			Discount discount2 = extDiscount.get();
			
			discount2.setCode(discount.getCode());
			discount2.setDiscount_value(discount.getDiscount_value());
			discount2.setQuantity(discount.getQuantity());
			discount2.setDescription(discount.getDescription());
			discount2.setStart_date(discount.getStart_date());
			discount2.setEnd_date(discount.getEnd_date());
			return discountJPA.save(discount);
		}else {
			return discountJPA.save(discount);
		}
	}

	public void deleteDiscount(int id) {
		if (discountJPA.existsById(id)) {
			discountJPA.deleteById(id);
		}else {
			throw new IllegalArgumentException("discount id: "+id+"error");
		}
	}

	public Optional<Discount> getDiscountById(int id){
		return discountJPA.findById(id);
	}
	public List<Discount> getAllDiscounts(){
		return discountJPA.findAll();
	}
	public boolean discountExists(int id) {
		return discountJPA.existsById(id);
	}
}
