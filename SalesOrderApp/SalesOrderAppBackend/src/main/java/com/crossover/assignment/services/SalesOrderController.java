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

import com.crossover.assignment.model.SalesOrder;
import com.crossover.assignment.model.Status;
import com.crossover.assignment.services.dao.DataServices;

@Controller
@RequestMapping("/salesorder")
public class SalesOrderController {
	@Autowired
	DataServices dataServices;

	static final Logger logger = Logger
			.getLogger(com.crossover.assignment.model.SalesOrder.class);

	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Status addSalesOrder(@RequestBody SalesOrder salesOrder) {
		try {
			dataServices.addEntity(salesOrder);
			return new Status(1, "SalesOrder added Successfully !");
		} catch (Exception e) {
			// e.printStackTrace();
			return new Status(0, e.toString());
		}

	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody List<SalesOrder> getSalesOrder() {

		List<Object> salesOrderList = null;
		try {
			salesOrderList = dataServices.getEntityList(SalesOrder.class);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return (List<SalesOrder>) (Object) salesOrderList;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody SalesOrder getSalesOrder(@PathVariable("id") String id) {
		SalesOrder salesOrder = null;
		try {
			salesOrder = (SalesOrder) dataServices.getEntityById(
					SalesOrder.class, id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return salesOrder;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Status deleteSalesOrder(@PathVariable("id") String id) {

		try {
			dataServices.deleteEntity(SalesOrder.class, id);
			return new Status(1, "SalesOrder deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}

}
