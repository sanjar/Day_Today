package com.crossover.assignment.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crossover.assignment.model.Product;
import com.crossover.assignment.model.Status;
import com.crossover.assignment.services.dao.DataServices;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	DataServices dataServices;

	static final Logger logger = Logger.getLogger(ProductController.class);

	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Status addProduct(@RequestBody Product product) {
		try {
			dataServices.addEntity(product);
			return new Status(1, "Product added Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody List<Product> getProduct() {

		List<Object> productList = null;
		try {
			productList = dataServices.getEntityList(Product.class);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return (List<Product>) (Object) productList;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Product getProduct(@PathVariable("id") String id) {
		Product product = null;
		try {
			product = (Product) dataServices.getEntityById(Product.class, id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Status deleteProduct(@PathVariable("id") String id) {

		try {
			dataServices.deleteEntity(Product.class, id);
			return new Status(1, "Product deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
}
