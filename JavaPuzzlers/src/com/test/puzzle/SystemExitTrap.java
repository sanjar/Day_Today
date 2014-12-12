package com.test.puzzle;

import java.util.Set;

public class SystemExitTrap {

	public static void main(String[] args) {
		try{
			
	  Runtime.getRuntime().addShutdownHook(new Thread() {
		public void run() {
			System.out.println("Inside Shutdouwn hook");
			Set<Thread> threads = Thread.getAllStackTraces().keySet();
			for(Thread thread:threads){
				if (thread.isAlive() && thread.isDaemon()) {
					if ("Deamon".equals(thread.getName())) {
						try {
							thread.join();
							System.out.println("my " + thread.getName() + " Thread completed.");
							break;
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	});		
			
		System.out.println("Started....");
		
		
		Thread th = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(6000);
					System.out.println("in Side thread : " + Thread.currentThread().getName());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		});
		th.setName("Deamon");
		th.setDaemon(true);
		th.start();
		//System.exit(0);   // You can test it with this also.
		int i =0;
		int value =10/i;
		}
		finally{
			System.out.println("In finally");
		}
	}
}
