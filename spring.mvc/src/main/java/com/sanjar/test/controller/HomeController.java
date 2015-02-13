package com.sanjar.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sanjar.test.model.Contact;

@Controller
public class HomeController {
	
	
	
	
	@RequestMapping(value = "contactList",method = RequestMethod.GET)
	public ModelAndView loadContactListPage(){
		
		//you can put your database logic here
		
		Contact contact1 = new Contact();
		contact1.setName("sadique");
		contact1.setEmail("abc@abc.com");
		contact1.setAddress("Banagalore");
		contact1.setContactNumber("78663636");
		
		Contact contact2 = new Contact();
		contact2.setName("sanjar");
		contact2.setEmail("pqr@abc.com");
		contact2.setAddress("Delhi");
		contact2.setContactNumber("356848");
		
		List<Contact> contactList = new ArrayList<Contact>();
		contactList.add(contact1);
		contactList.add(contact2);
		ModelAndView view = new ModelAndView("contactList");
		view.addObject("contactList", contactList);
		return view;
	}
	
	@RequestMapping(value = "home",method = RequestMethod.GET)
	public ModelAndView loadHomePage(){
		
		ModelAndView view = new ModelAndView("home");
		return view;
	}
	
	
	
	
}
