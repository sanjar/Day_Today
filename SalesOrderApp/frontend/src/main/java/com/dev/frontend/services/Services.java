package com.dev.frontend.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.dev.frontend.model.Customer;
import com.dev.frontend.model.Product;
import com.dev.frontend.model.SalesOrder;
import com.dev.frontend.model.Status;
import com.dev.frontend.panels.ComboBoxItem;

public class Services {
	public static final int TYPE_PRODUCT = 1;
	public static final int TYPE_CUSTOMER = 2;
	public static final int TYPE_SALESORDER = 3;

	public static Object save(Object object, int objectType) {
		/*
		 * This method is called eventually after you click save on any edit
		 * screen object parameter is the return object from calling method
		 * guiToObject on edit screen and the type is identifier of the object
		 * type and may be TYPE_PRODUCT , TYPE_CUSTOMER or TYPE_SALESORDER
		 */
		String objectTypeName = getObjectTypeName(objectType);
		System.out.println(objectTypeName);
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(
				"http://localhost:8080/SalesOrderAppBackend/" + objectTypeName
						+ "/save");
		try {
			String json = getJsonStringFromObject(object);
			System.out.println(json);
			StringEntity input = new StringEntity(json, "UTF-8");
			input.setContentType("application/json; charset=UTF-8");
			post.setEntity(input);
			HttpResponse response = client.execute(post);
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent()));
			String line = "";
			while ((line = rd.readLine()) != null) {
				ObjectMapper mapper = new ObjectMapper();
				Status status = mapper.readValue(line.getBytes(), Status.class);
				System.out.println(line);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return object;
	}

	private static String getJsonStringFromObject(Object object)
			throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(object);
	}

	public static Object readRecordByCode(String code, int objectType) {
		/*
		 * This method is called when you select record in list view of any
		 * entity and also called after you save a record to re-bind the record
		 * again the code parameter is the first column of the row you have
		 * selected and the type is identifier of the object type and may be
		 * TYPE_PRODUCT , TYPE_CUSTOMER or TYPE_SALESORDER
		 */
		String objectTypeName = getObjectTypeName(objectType);
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(
				"http://localhost:8080/SalesOrderAppBackend/" + objectTypeName
						+ "/" + code);
		HttpResponse response;
		Object object = null;
		try {
			response = client.execute(request);
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent()));
			String line = "";

			while ((line = rd.readLine()) != null) {
				object = getObjectFromJsonResponse(line, objectType);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return object;
	}

	private static Object getObjectFromJsonResponse(String line, int objectType)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Object object = null;
		if (objectType == TYPE_CUSTOMER) {
			object = mapper.readValue(line.getBytes(), Customer.class);
		} else if (objectType == TYPE_PRODUCT) {
			object = mapper.readValue(line.getBytes(), Product.class);
		} else if (objectType == TYPE_SALESORDER) {
			object = mapper.readValue(line.getBytes(), SalesOrder.class);
		}
		return object;
	}

	public static boolean deleteRecordByCode(String code, int objectType) {
		/*
		 * This method is called when you click delete button on an edit view
		 * the code parameter is the code of (Customer - PRoduct ) or order
		 * number of Sales Order and the type is identifier of the object type
		 * and may be TYPE_PRODUCT , TYPE_CUSTOMER or TYPE_SALESORDER
		 */

		String objectTypeName = getObjectTypeName(objectType);
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(
				"http://localhost:8080/SalesOrderAppBackend/" + objectTypeName
						+ "/delete/" + code);
		HttpResponse response;
		try {
			response = client.execute(request);
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent()));
			String line = "";

			while ((line = rd.readLine()) != null) {
				ObjectMapper mapper = new ObjectMapper();
				Status status = mapper.readValue(line.getBytes(), Status.class);
				if (status.getCode() == 1) {
					return true;
				}
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static List<Object> listCurrentRecords(int objectType) {
		/*
		 * This method is called when you open any list screen and should return
		 * all records of the specified type
		 */

		String objectTypeName = getObjectTypeName(objectType);
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(
				"http://localhost:8080/SalesOrderAppBackend/" + objectTypeName
						+ "/list");
		HttpResponse response;
		List<Object> recordObjects = new ArrayList<Object>();
		try {
			response = client.execute(request);
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent()));
			String line = "";

			while ((line = rd.readLine()) != null) {
				recordObjects = getObjectArrayFromJsonResponse(line, objectType);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return recordObjects;
	}

	private static List<Object> getObjectArrayFromJsonResponse(String line,
			int objectType) throws IOException, JsonParseException,
			JsonMappingException {
		ObjectMapper mapper = new ObjectMapper();
		List<Object> recordObjects = new ArrayList<Object>();
		Object[] object = null;
		if (objectType == TYPE_CUSTOMER) {
			object = mapper.readValue(line.getBytes(), Customer[].class);
		} else if (objectType == TYPE_PRODUCT) {
			object = mapper.readValue(line.getBytes(), Product[].class);
		} else if (objectType == TYPE_SALESORDER) {
			object = mapper.readValue(line.getBytes(), SalesOrder[].class);
		}
		recordObjects.addAll(Arrays.asList(object));
		return recordObjects;
	}

	private static String getObjectTypeName(int objectType) {
		switch (objectType) {
		case 1:
			return "product";
		case 2:
			return "customer";
		case 3:
			return "salesorder";
		}
		return "";
	}

	public static List<ComboBoxItem> listCurrentRecordRefernces(int objectType) {
		/*
		 * This method is called when a Combo Box need to be initialized and
		 * should return list of ComboBoxItem which contains code and
		 * description/name for all records of specified type
		 */

		List<Object> list = listCurrentRecords(objectType);
		ArrayList<ComboBoxItem> comboList = new ArrayList<ComboBoxItem>();
		for (Object obj : list) {
			ComboBoxItem boxItem = new ComboBoxItem();
			if (TYPE_CUSTOMER == objectType) {
				Customer customer = (Customer) obj;
				boxItem.setKey(customer.getCustomerCode());
				boxItem.setValue(customer.getCustomerName());
			}
			if (TYPE_PRODUCT == objectType) {
				Product product = (Product) obj;
				boxItem.setKey(product.getProductCode());
				boxItem.setValue(product.getProductDescription());
			}
			if (TYPE_SALESORDER == objectType) {
				SalesOrder salesOrder = (SalesOrder) obj;
				boxItem.setKey(String.valueOf(salesOrder.getOrderNumber()));
				boxItem.setValue(salesOrder.getProducts());
			}
			comboList.add(boxItem);
		}
		return comboList;
	}

	public static double getProductPrice(String productCode) {
		/*
		 * This method is used to get unit price of product with the code passed
		 * as a parameter
		 */
		Product product = (Product) Services.readRecordByCode(productCode,
				TYPE_PRODUCT);
		return product.getProductPrice();
	}
}
