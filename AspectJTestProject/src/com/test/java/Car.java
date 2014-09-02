package com.test.java;

public abstract class Car implements Vehicle {

	@Override
	public abstract void toDrive();

	@Override
	public void applyBrake(int brakeType){
		try{
			if(brakeType<-1){
				throw new BreakNotWorkingException("Brake Type is : " + brakeType);
			}
			else{
				System.out.println("Break Applied");
			}
		}
		catch(BreakNotWorkingException ex){
			ex.printStackTrace();
		}
		
		

	}

	@Override
	public abstract String getModel();

	@Override
	public abstract Double getPrice();

}
