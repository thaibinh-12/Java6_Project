package com.shopme.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopme.common.entity.Brand;
import com.shopme.common.entity.Review;
import com.shopme.user.jpa.ReviewJPA;

@Service
public class ReviewService {
	@Autowired
	private ReviewJPA reviewJPA;
	
	public Review saveOrUpdateRiview(Review review) {
		Optional<Review> extReview = reviewJPA.findById(review.getId());
		
		if(extReview.isPresent()) {
			Review review2 = extReview.get();
			
			//note
			review2.setRating(review.getRating());
			review2.setDescription(review.getDescription());
			
			return reviewJPA.save(review2);
		}else {
			return reviewJPA.save(review);
		}
	}
	
	public void deleteReview(int id) {
		if (reviewJPA.existsById(id)) {
			reviewJPA.deleteById(id);
		}else {
			throw new IllegalArgumentException("review id: "+id+"error");
		}
	}
	
	
	public Optional<Review> getReviewById(int id){
		return reviewJPA.findById(id);
	}
	public List<Review> getAllReview(){
		return reviewJPA.findAll();
	}
	public boolean reviewExists(int id) {
		return reviewJPA.existsById(id);
	}
}
