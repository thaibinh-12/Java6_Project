package com.shopme.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopme.common.entity.Address;
import com.shopme.user.jpa.AddressJPA;

@Service
public class AddressService {
	@Autowired
	private AddressJPA addressJPA;

	public Address saveOrUppdateAddress(Address address) {
		Optional<Address> extAddress = addressJPA.findById(address.getId());

		if (extAddress.isPresent()) {
			Address extAddress2 = extAddress.get();

			extAddress2.setProvinceId(address.getProvinceId());
			extAddress2.setDistrictId(address.getDistrictId());
			extAddress2.setWardCode(address.getWardCode());
			extAddress2.setAddress(address.getAddress());
			extAddress2.setFull_address(address.getFull_address());
			extAddress2.setActived(address.isActived());
			return addressJPA.save(address);
		} else {
			return addressJPA.save(address);
		}

	}

	public void deleteAddress(int id) {
		if (addressJPA.existsById(id)) {
			addressJPA.deleteById(id);
		} else {
			throw new IllegalArgumentException("Address id" + id + "error");
		}
	}

	public Optional<Address> getAccountById(int id){
		return addressJPA.findById(id);
	}
	
	public List<Address> getAllAddresses(){
		return addressJPA.findAll();
	}
	
	public boolean addressExists(int id) {
		return addressJPA.existsById(id);
	}
}
