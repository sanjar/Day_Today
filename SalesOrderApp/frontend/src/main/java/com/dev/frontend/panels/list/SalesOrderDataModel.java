package com.dev.frontend.panels.list;

import java.util.List;

import com.dev.frontend.model.SalesOrder;
import com.dev.frontend.services.Services;

public class SalesOrderDataModel extends ListDataModel {
	private static final long serialVersionUID = 7526529951747614655L;

	public SalesOrderDataModel() {
		super(new String[] { "Order Number", "Customer", "Total Price" }, 0);
	}

	@Override
	public int getObjectType() {
		return Services.TYPE_SALESORDER;
	}

	@Override
	public String[][] convertRecordsListToTableModel(List<Object> list) {
		/*
		 * This method use list returned by Services.listCurrentRecords and
		 * should convert it to array of rows each row is another array of
		 * columns of the row
		 */

		String[][] salesOrderArrayData = getSalesOrderArrayData(list);
		return salesOrderArrayData;
	}

	private String[][] getSalesOrderArrayData(List<Object> salesOrderList) {
		String[][] salesOrderArrayData = new String[salesOrderList.size()][];
		int i = 0;
		for (Object obj : salesOrderList) {
			SalesOrder salesOrder = (SalesOrder) obj;
			salesOrderArrayData[i] = new String[] {
					String.valueOf(salesOrder.getOrderNumber()),
					salesOrder.getCustomer().getCustomerName(),
					String.valueOf(salesOrder.getTotalPrice()) };
		}
		return salesOrderArrayData;
	}
}
