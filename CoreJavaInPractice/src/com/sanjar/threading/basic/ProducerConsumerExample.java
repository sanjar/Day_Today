package com.sanjar.threading.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProducerConsumerExample {
	
	
	
	public static void main(String[] args) {
		Producer producer = new Producer();
		producer.start();
		Consumer consumer = new  Consumer(producer);
		consumer.start();
		
		
		
	}
	
}

class Consumer extends Thread{
	private Producer producer;
	//public static final Object object = new Object();
	public Consumer(Producer producer) {
		this.producer=producer;
	}

	@Override
	public void run() {
		
			try{
				while(true){
					synchronized (producer) {
					producer.notify();
					while(producer.getList().size()==0){
						producer.wait();
					}
					Integer i=producer.getList().get(0);
					System.out.println("Consuming........"+ i);
					producer.getList().remove(0);
					//notifyAll();
				}
				}
				}catch(InterruptedException ex){
					ex.printStackTrace();
				}
			 
		}
		
}

class Producer extends Thread{
	private static final int MAX_LIMIT=10;
	private List<Integer> list = new ArrayList<Integer>(MAX_LIMIT);
	private Random random = new Random();
	@Override
	public void run() {
		
			try{
				while(true){
					synchronized (this) {
					while(list.size()==MAX_LIMIT){
						wait();
					}
					list.add(random.nextInt());
					System.out.println("Producing..........");
					notify();
				}
				}
				}catch(InterruptedException ex){
					ex.printStackTrace();
				}
		
		
	}
	public List<Integer> getList() {
		return list;
	}
}