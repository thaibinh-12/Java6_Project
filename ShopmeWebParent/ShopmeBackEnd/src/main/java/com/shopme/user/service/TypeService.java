package com.shopme.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shopme.common.entity.Type;
import com.shopme.user.jpa.TypeJPA;

@Service
public class TypeService {
	@Autowired
	private TypeJPA typeJPA;
	
	public Type saveOrUpdateType(Type type) {
		Optional<Type> extType = typeJPA.findById(type.getId());
		
		if (extType.isPresent()) {
			Type type2 = extType.get();
			type2.setName(type.getName());
			
			return typeJPA.save(type2);
		}else {
			return typeJPA.save(type);
		}
	}
	
	public void deleteType(int id) {
		if (typeJPA.existsById(id)) {
			typeJPA.deleteById(id);
		}else {
			throw new IllegalArgumentException("type id: "+id+"error");
		}
	}

	public Optional<Type> getTypeById(int id){
		return typeJPA.findById(id);
	}
	public List<Type> getAllType(){
		return typeJPA.findAll();
	}
	public boolean typeExists(int id) {
		return typeJPA.existsById(id);
	}
}
