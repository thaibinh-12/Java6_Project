package com.shopme.user.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopme.common.entity.Order;
import com.shopme.common.entity.Order_Detail;
import com.shopme.common.entity.Variant;
import com.shopme.user.jpa.OrderJPA;
import com.shopme.user.jpa.Order_DetailJPA;
import com.shopme.user.jpa.VariantJPA;

import jakarta.persistence.EntityNotFoundException;

@Service
public class OrderService {
	@Autowired
	private OrderJPA orderJPA;
	@Autowired
	private Order_DetailJPA order_DetailJPA;

	@Autowired
	private VariantJPA variantJPA;
	
	public Order createOrder (int accountId, int discountId, String description, int paymentMethod, int fee, String addressFull) {
		Order order = new Order();
		//note
//		order.setAccount(accountId);
		//order.setDiscount(discountId);
		order.setDate(new Date());
		order.setStatus(1);
		order.setDescription(description);
		order.setPayment_method(paymentMethod);
		order.setFee(fee);
		order.setFull_address(addressFull);
		
		//note
		order.setTotal_price(0);
		
		return orderJPA.save(order);
	}
	
	public void addOrderDetail(int orderId, int variantId, int quantity) {
		Optional<Variant> vaOptional = variantJPA.findById(variantId);
		if (vaOptional.isPresent()) {
			Variant variant = vaOptional.get();
			
			Order_Detail order_Detail = new Order_Detail();
			//note
			//order_Detail.setOrder(orderId);
			//order_Detail.setVariant(variantId);
			order_Detail.setQuantity(quantity);
			order_Detail.setPrice(variant.getPrice());
			
			order_DetailJPA.save(order_Detail);
			
			Order order = orderJPA.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
		
			int newTotalPrice = order.getTotal_price() + (variant.getPrice() * quantity);
            order.setTotal_price(quantity);
            orderJPA.save(order);
		}else {
			throw new RuntimeException("variant not found");
		}
	}
	
	
	public void deleteOrder(int orderId) {
		Optional<Order> orderOptional = orderJPA.findById(orderId);

		if (orderOptional.isPresent()) {
			Order order = orderOptional.get();
			orderJPA.delete(order);
		} else {
			throw new EntityNotFoundException("Order not found");
		}
	}
	
	//get all list
//	public List<Order> getOrderByAcccount(int accountId){
//		
//	}
}
