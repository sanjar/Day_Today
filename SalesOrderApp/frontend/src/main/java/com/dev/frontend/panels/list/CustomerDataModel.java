package com.dev.frontend.panels.list;

import java.util.List;

import com.dev.frontend.model.Customer;
import com.dev.frontend.services.Services;

public class CustomerDataModel extends ListDataModel {
	private static final long serialVersionUID = 7526529951747613655L;

	public CustomerDataModel() {
		super(new String[] { "Code", "Name", "Phone", "Current Credit" }, 0);
	}

	@Override
	public int getObjectType() {
		return Services.TYPE_CUSTOMER;
	}

	@Override
	public String[][] convertRecordsListToTableModel(List<Object> list) {
		// TODO by the candidate
		/*
		 * This method use list returned by Services.listCurrentRecords and
		 * should convert it to array of rows each row is another array of
		 * columns of the row
		 */
		String[][] sampleData = new String[][] {
				{ "01", "Customer 1", "+201011121314", "23.4" },
				{ "02", "Customer 2", "+201112131415", "1.4" } };

		List<Object> customerList = Services
				.listCurrentRecords(Services.TYPE_CUSTOMER);

		String[][] customerArrayData = getCustomerArrayData(customerList);
		return customerArrayData;
	}

	private String[][] getCustomerArrayData(List<Object> customerList) {
		String[][] customerArrayData = new String[customerList.size()][4];
		int i = 0;
		for (Object obj : customerList) {
			Customer customer = (Customer) obj;
			customerArrayData[i] = new String[] { customer.getCustomerCode(),
					customer.getCustomerName(), customer.getCustomerPhone(),
					customer.getCustomerCurrentCredit() };
		}
		return customerArrayData;
	}
}
