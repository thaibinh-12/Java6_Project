package com.shopme.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopme.common.entity.Size;
import com.shopme.common.entity.Type;
import com.shopme.user.jpa.SizeJPA;
import com.shopme.user.jpa.TypeJPA;

@Service
public class SizeService {
	@Autowired
	private SizeJPA sizeJPA;
	
	public Size saveOrUpdateType(Size size) {
		Optional<Size> extSize = sizeJPA.findById(size.getId());
		
		if (extSize.isPresent()) {
			Size size2 = extSize.get();
			size2.setSize(size.getSize());
			
			return sizeJPA.save(size2);
		}else {
			return sizeJPA.save(size);
		}
	}
	
	public void deleteSize(int id) {
		if (sizeJPA.existsById(id)) {
			sizeJPA.deleteById(id);
		}else {
			throw new IllegalArgumentException("size id: "+id+"error");
		}
	}

	public Optional<Size> getSizeById(int id){
		return sizeJPA.findById(id);
	}
	public List<Size> getAllSize(){
		return sizeJPA.findAll();
	}
	public boolean sizeExists(int id) {
		return sizeJPA.existsById(id);
	}
}
