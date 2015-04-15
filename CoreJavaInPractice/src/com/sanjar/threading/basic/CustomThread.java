package com.sanjar.threading.basic;

public class CustomThread extends Thread{

	@Override
	public void run() {
		System.out.println("Custom Thread Name: "+Thread.currentThread().getName());
		System.out.println("Custom Thread Priority: "+Thread.currentThread().getPriority());
		
	}
	
	public static void main(String[] args) {
		CustomThread customThread = new CustomThread();
		customThread.start();
		System.out.println("Main Thread Name: "+Thread.currentThread().getName());
		

		
		
	}
}
