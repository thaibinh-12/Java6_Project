package com.shopme.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopme.user.jpa.AccountJPA;

@Controller
@RequestMapping("/conan")
public class ProfileController {
	@Autowired
	AccountJPA accountJPA;
	
	@RequestMapping("/profile")
	public String getAccount(Model model) {
		model.addAttribute("profile",accountJPA.findAll());
		return "user/profile";
	}
}
