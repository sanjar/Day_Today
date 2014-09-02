package com.test.java;

public interface Vehicle {

   public void toDrive();
   public void applyBrake(int brakeType) throws BreakNotWorkingException;
   public String getModel();
   public Double getPrice();
   public Double getMinPrice();
}
