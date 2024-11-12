package com.shopme.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopme.common.entity.Color;
import com.shopme.common.entity.Size;
import com.shopme.common.entity.Type;
import com.shopme.user.jpa.ColorJPA;
import com.shopme.user.jpa.SizeJPA;
import com.shopme.user.jpa.TypeJPA;

@Service
public class ColorService {
	@Autowired
	private ColorJPA colorJPA;
	
	public Color saveOrUpdateColor(Color color) {
		Optional<Color> extColor = colorJPA.findById(color.getId());
		
		if (extColor.isPresent()) {
			Color color2  = extColor.get();
			color2.setColor(color.getColor());
			
			return colorJPA.save(color2);
		}else {
			return colorJPA.save(color);
		}
	}
	
	public void deleteColor(int id) {
		if (colorJPA.existsById(id)) {
			colorJPA.deleteById(id);
		}else {
			throw new IllegalArgumentException("color id: "+id+"error");
		}
	}

	public Optional<Color> getColorById(int id){
		return colorJPA.findById(id);
	}
	public List<Color> getAllColor(){
		return colorJPA.findAll();
	}
	public boolean colorExists(int id) {
		return colorJPA.existsById(id);
	}
}
