package com.shopme.user.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shopme.common.entity.Favorite;
import com.shopme.user.jpa.FavoriteJPA;

@Service
public class FavoriteService {
	@Autowired
	private FavoriteJPA favoriteJPA;

	public Favorite addFavorite(Favorite favorite) {
		if (favoriteJPA.existsByUserIdAndProductId(favorite.getAccount().getId(), favorite.getProduct().getId())) {
			throw new IllegalArgumentException("Add success");
		}
		return favoriteJPA.save(favorite);
	}
	
	public void deleteFavorite(int accountId, int productId) {
		if (favoriteJPA.existsByUserIdAndProductId(accountId, productId)) {
			favoriteJPA.deleteByUserIdAndProductId(accountId, productId);
		}else {
			throw new IllegalArgumentException("Remove succcess");
		}
	}
	
	public List<Favorite> getAllFavorites(int accountId){
		return favoriteJPA.findByAccountId(accountId);
	}
}
