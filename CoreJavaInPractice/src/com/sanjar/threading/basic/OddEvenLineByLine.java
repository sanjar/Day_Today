package com.sanjar.threading.basic;

public class OddEvenLineByLine {
	boolean flag = true;
	static int count=1;
public static void main(String[] args) {
	OddEvenLineByLine byLine = new OddEvenLineByLine();
		
	Thread t1 = new Thread(new Runnable() {
	
		@Override
		public void run() {
			synchronized (byLine) {
				while(true){
				System.out.print(count++);
				System.out.print(" ");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				byLine.flag=false;
				try {
					while(!byLine.flag){
						byLine.notify();
					
					byLine.wait();
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			}
			
			
		}
	});
	
	Thread t2 = new Thread(new Runnable() {
		
		@Override
		public void run() {
			synchronized (byLine) {
				while(true){
					try {
						while(byLine.flag){
						byLine.wait();
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(count++);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                    byLine.flag =true;
                   // while(!byLine.flag){
                    	byLine.notify();
                   // }
				}
			}
		}
	});
	t1.start();
	t2.start();
}
	
}
