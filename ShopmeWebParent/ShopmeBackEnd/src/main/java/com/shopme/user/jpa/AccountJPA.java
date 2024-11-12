package com.shopme.user.jpa;


import org.springframework.data.jpa.repository.JpaRepository;

import com.shopme.common.entity.Account;

public interface AccountJPA extends JpaRepository<Account, Integer> {
}
