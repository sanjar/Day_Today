package com.test.aspect;

import com.test.java.MercClassA;
import com.test.java.Vehicle;

public class TestMain {

	public static void main(String[] args) {
		Vehicle vehicle = new MercClassA();
		System.out.println("The Price of " + vehicle.getModel() + " is "+ vehicle.getPrice());
		System.out.println("from main: "+((MercClassA)vehicle).getExactModel());
		System.out.println("Hi");
	}
}
