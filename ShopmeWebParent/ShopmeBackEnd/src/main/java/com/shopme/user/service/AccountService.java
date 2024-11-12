package com.shopme.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopme.common.entity.Account;
import com.shopme.user.jpa.AccountJPA;

@Service
public class AccountService {

	@Autowired
	private AccountJPA accountJPA;

	
	public Account saveOrUpdateAccount(Account account) {
	        Optional<Account> extAccount = accountJPA.findById(account.getId());
	        if (extAccount.isPresent()) {
	            Account acc = extAccount.get();
	          
	            acc.setName(account.getName());
	            acc.setPhone(account.getPhone());
	            acc.setGender(account.isGender());
	            acc.setImage(account.getImage());
	            acc.setEmail(account.getEmail());
	            acc.setPassword(account.getPassword());
	            
	            return accountJPA.save(acc);
	        } else {
	        		
	            return accountJPA.save(account);
	        }
	    }
	 
	public void deleteAccount(int id) {
	        accountJPA.deleteById(id);
	    }

	public Optional<Account> findById(int id) {
		return accountJPA.findById(id);
	}
	
	public List<Account> getAllAccounts() {
        return accountJPA.findAll();
    }

	public boolean accountExists(int id) {
		return accountJPA.existsById(id);
	}
}
