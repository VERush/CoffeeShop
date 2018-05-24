package com.gc.coffeeshop.CoffeeShop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class CoffeeController {
	
	@Autowired
	User registeredUser;

	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index", "coffeeText", "Welcome to GC COFFEE!");
	}
	
	@RequestMapping("/regform")
	public ModelAndView testing() {
		return new ModelAndView("regform");
	}
	
	@RequestMapping("/register")
	public ModelAndView formTest(@RequestParam("fName") String firstName, 
			@RequestParam("lName") String lastName, @RequestParam("email") String email,
			@RequestParam("phone") String phone, @RequestParam("password") String password) {
		registeredUser.setFirstName(firstName);
		registeredUser.setLastName(lastName);
		registeredUser.setEmail(email);
		registeredUser.setPhone(phone);
		registeredUser.setPassword(password);
		
		return new ModelAndView("welcome", "user", registeredUser);
	}
}
