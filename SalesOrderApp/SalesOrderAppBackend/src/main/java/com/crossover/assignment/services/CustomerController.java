package com.crossover.assignment.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crossover.assignment.model.Customer;
import com.crossover.assignment.model.Status;
import com.crossover.assignment.services.dao.DataServices;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	DataServices dataServices;

	static final Logger logger = Logger.getLogger(CustomerController.class);

	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Status addCustomer(@RequestBody Customer customer) {
		try {
			dataServices.addEntity(customer);
			return new Status(1, "Customer added Successfully !");
		} catch (Exception e) {
			// e.printStackTrace();
			return new Status(0, e.toString());
		}

	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody List<Customer> getCustomer() {

		List<Object> customerList = null;
		try {
			customerList = dataServices.getEntityList(Customer.class);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return (List<Customer>) (Object) customerList;
	}

}
