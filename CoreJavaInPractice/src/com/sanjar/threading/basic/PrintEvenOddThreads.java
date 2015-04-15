package com.sanjar.threading.basic;

public class PrintEvenOddThreads {

	public static void main(String[] args) {
		Odd odd = new  Odd();
		Thread oddThread = new Thread(odd); 
		oddThread.start();
		Thread evenThread = new Thread(new Even(odd));
		evenThread.start();
	}
}

class Even implements Runnable{
	private Odd odd;
	private int evenCount=0;
	public Even(Odd odd) {
		this.odd= odd;
	}

	@Override
	public void run(){
		try{
			while(true){
				synchronized (odd) {
					while(!odd.isLastOddPrinted()){
						odd.wait();
					}
					evenCount = evenCount+2;
					Thread.sleep(300);
					System.out.println(evenCount);
					odd.setLastOddPrinted(false);
					odd.notify();
				}
			}
			
			}catch(InterruptedException ex){
				ex.printStackTrace();
			}
	}
	
}

class Odd implements Runnable{
	private boolean isLastOddPrinted=false;
	private int oddCount=-1;
	@Override
	public void run() {
		try{
		while(true){
			synchronized (this) {
				while(isLastOddPrinted){
					wait();
				}
				oddCount = oddCount+2;
				Thread.sleep(300);
				System.out.println(oddCount);
				isLastOddPrinted=true;
				notify();
			}
		}
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}
	}
	public boolean isLastOddPrinted() {
		return isLastOddPrinted;
	}
	public void setLastOddPrinted(boolean isLastOddPrinted) {
		this.isLastOddPrinted = isLastOddPrinted;
	}
	
}