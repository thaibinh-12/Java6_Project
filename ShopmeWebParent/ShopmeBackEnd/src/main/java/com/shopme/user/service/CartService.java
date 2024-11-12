package com.shopme.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopme.common.entity.Cart_Detail;
import com.shopme.common.entity.Variant;
import com.shopme.user.jpa.Cart_DetailJPA;
import com.shopme.user.jpa.VariantJPA;

@Service
public class CartService {
	@Autowired
	private Cart_DetailJPA cart_DetailJPA;
	@Autowired
	private VariantJPA variantJPA;
	
	
	public List<Cart_Detail> getAllCarts(){
		return cart_DetailJPA.findAll();
	}
	
	public Cart_Detail addProductToCart(int cartId, int variantId, int quantity) {
		Optional<Cart_Detail> extCart = cart_DetailJPA.findByCartIdAndVariantId(cartId, variantId);
	
		if (extCart.isPresent()) {
			Cart_Detail cart_Detail = extCart.get();
			cart_Detail.setQuantity(cart_Detail.getQuantity()+quantity);
			return cart_DetailJPA.save(cart_Detail);
		}else {
			Optional<Variant> variant = variantJPA.findById(variantId);
			if (variant.isPresent()) {
				Cart_Detail newCartDetail = new Cart_Detail();
				newCartDetail.setId(cartId);
				newCartDetail.setQuantity(quantity);
				newCartDetail.setVariant(variant.get());
				//note
				
				return cart_DetailJPA.save(newCartDetail);
			}else {
				throw new IllegalArgumentException("variant id"+variantId+"error");
			}
		}
	}
	
}
