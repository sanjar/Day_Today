package com.dev.frontend.panels.list;

import java.util.List;

import com.dev.frontend.model.Product;
import com.dev.frontend.services.Services;

public class ProductDataModel extends ListDataModel {
	private static final long serialVersionUID = 7526529951747614655L;

	public ProductDataModel() {
		super(new String[] { "Code", "Description", "Price", "Quantity" }, 0);
	}

	@Override
	public int getObjectType() {
		return Services.TYPE_PRODUCT;
	}

	@Override
	public String[][] convertRecordsListToTableModel(List<Object> list) {
		/*
		 * This method use list returned by Services.listCurrentRecords and
		 * should convert it to array of rows each row is another array of
		 * columns of the row
		 */

		String[][] productArrayData = getProductArrayData(list);
		return productArrayData;
	}

	private String[][] getProductArrayData(List<Object> productList) {
		String[][] productArrayData = new String[productList.size()][];
		int i = 0;
		for (Object obj : productList) {
			Product product = (Product) obj;
			productArrayData[i] = new String[] {
					String.valueOf(product.getProductCode()),
					product.getProductDescription(),
					String.valueOf(product.getProductPrice()),
					String.valueOf(product.getProductQuantity()) };
		}
		return productArrayData;
	}
}
