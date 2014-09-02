package com.test.aspect;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.test.java.Vehicle;

public aspect ConditionalPointcut {

	private static final Logger LOGGER = Logger.getLogger("LoggingAspect");
	ConditionalPointcut() {
		System.out.println("In Aspect : "+ this.getClass().getName());
		System.out.println();
	}
	
	
	pointcut getPriceOnCall() : execution(Double com.test.java.Vehicle.getPrice()) && if(((Vehicle)thisJoinPoint.getThis()).getMinPrice()>30000);
	Double around(): getPriceOnCall(){
		System.out.println("this: " + thisJoinPoint.getThis());
		System.out.println("this: " + thisJoinPointStaticPart.toLongString());
		LOGGER.log(Level.INFO, "just after call and before starting execution");
		Double price= proceed();
		LOGGER.log(Level.INFO, "preceed called");
		return price;
	}
	
	public static Double getMinPrice(){
		return (double) 30000;
	}
	
}
