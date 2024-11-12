package com.shopme.user.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopme.common.entity.Address;

public interface AddressJPA extends JpaRepository<Address, Integer>{

}
