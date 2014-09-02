package com.test.java;

public class MercClassA extends Car{

	@Override
	public void toDrive() {
		System.out.println("Both Hand driving");
		
	}

	@Override
	public String getModel() {
		String m =getExactModel();
		if(m !=null){
			return m;
		}
		return "Class A";
	}

	
	public String getExactModel() {
		System.out.println("Inside getExactModel() ");
		return null;
	}

	@Override
	public Double getPrice() {
		return 100000.00;
	}

	@Override
	public Double getMinPrice() {
		// TODO Auto-generated method stub
		return (double) 200000;
	}

}
