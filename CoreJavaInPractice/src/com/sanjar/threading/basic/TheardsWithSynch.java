package com.sanjar.threading.basic;

public class TheardsWithSynch {

	static TheardsWithSynch synch = new TheardsWithSynch();
	Object obj = new Object();
	MyClass class1 = new MyClass();
	public static void main(String[] args) {
		Thread t1 = new Thread(new Thread1(),"thread 1");
		
		Thread t2 = new Thread(new Thread2(),"thread 2");
		
		Thread t3 = new Thread(new Thread3(),"thread 3");
		Thread t4 = new Thread(new Thread4(),"thread 4");
		t3.start();
		t1.start();
		t2.start();
		t4.start();
	}
	
	synchronized public String getName(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "myname";
		
	}
	public String getAddress(){
		synchronized (class1) {
			System.out.println("In getAddress "+Thread.currentThread().getName());
			synchronized (this) {
				return "my Address";
			}
		}
		
		
		
	}
}

class Thread1 implements Runnable{

	@Override
	public void run() {
		//System.out.println(Thread.currentThread().getName());
		System.out.println(TheardsWithSynch.synch.getName());
		
	}
	
}

class Thread2 implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		System.out.println(TheardsWithSynch.synch.getAddress());
		
	}
}
	class Thread3 implements Runnable{

		@Override
		public void run() {
			System.out.println(TheardsWithSynch.synch.getAddress());
			System.out.println(Thread.currentThread().getName());
		}
	
}
	class Thread4 implements Runnable{

		@Override
		public void run() {
			System.out.println(new TheardsWithSynch().getAddress());
			System.out.println(Thread.currentThread().getName());
		}
	
}	
	
	class MyClass {
		
	}