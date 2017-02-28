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
		/*
		 * This method use list returned by Services.listCurrentRecords and
		 * should convert it to array of rows each row is another array of
		 * columns of the row
		 */

		String[][] customerArrayData = getCustomerArrayData(list);
		return customerArrayData;
	}

	private String[][] getCustomerArrayData(List<Object> customerList) {
		String[][] customerArrayData = new String[customerList.size()][];
		int i = 0;
		for (Object obj : customerList) {
			Customer customer = (Customer) obj;
			customerArrayData[i] = new String[] {
					String.valueOf(customer.getCustomerCode()),
					customer.getCustomerName(),
					customer.getCustomerPhone1() + ","
							+ customer.getCustomerPhone2(),
					String.valueOf(customer.getCustomerCurrentCredit()) };
			i++;
		}
		return customerArrayData;
	}
}
