package com.test.aspect;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public aspect LoggingAspect {

	private static final Logger LOGGER = Logger.getLogger("LoggingAspect");
	LoggingAspect() {
		System.out.println("In Aspect : "+ this.getClass().getName());
	}
	
	//this is for Exceution
	/*pointcut getPrice() : execution(Double com.test.java.MercClassA.getPrice());
	Double around(): getPrice(){
		LOGGER.log(Level.INFO, "------------------ Info about thisJoinPoint  start ------------------");
		LOGGER.log(Level.INFO, "In :" +thisJoinPoint.getThis().getClass().getName()+ "--->"+ thisJoinPoint.getSignature());
		LOGGER.log(Level.INFO, "Signature : "+thisJoinPoint.getSignature());
		LOGGER.log(Level.INFO, "Signature Name: "+thisJoinPoint.getSignature().getName());
		LOGGER.log(Level.INFO, "Long String : "+thisJoinPoint.toLongString());
		LOGGER.log(Level.INFO, "Target : "+thisJoinPoint.getTarget());
		LOGGER.log(Level.INFO, "Target : "+thisJoinPoint.getSourceLocation());
		LOGGER.log(Level.INFO, "------------------ Info about thisJoinPoint Ends ------------------");
		LOGGER.log(Level.INFO, "Started geting Price info");
		
	    LOGGER.log(Level.INFO, "------------------ Info about thisJoinPointStaticPart  start ------------------");
	    
	    LOGGER.log(Level.INFO, "Signature of thisJoinPointStaticPart : "+thisJoinPointStaticPart.getSignature());
	    LOGGER.log(Level.INFO, "ID of thisJoinPointStaticPart : "+thisJoinPointStaticPart.getId());
	    LOGGER.log(Level.INFO, "Class of thisJoinPointStaticPart : "+thisJoinPointStaticPart.getClass());
	    LOGGER.log(Level.INFO, "Source Location of thisJoinPointStaticPart : "+thisJoinPointStaticPart.getSourceLocation());
	    LOGGER.log(Level.INFO, "File name of thisJoinPointStaticPart : "+thisJoinPointStaticPart.getSourceLocation().getFileName());
	    LOGGER.log(Level.INFO, "Name of thisJoinPointStaticPart : "+thisJoinPointStaticPart.getSourceLocation().getWithinType().getName());
	    LOGGER.log(Level.INFO, "Super Class of thisJoinPointStaticPart : "+thisJoinPointStaticPart.getSourceLocation().getWithinType().getSuperclass());
	    
	    LOGGER.log(Level.INFO, "------------------ Info about thisJoinPointStaticPart  ends ------------------");
	    
	    
	    
	    LOGGER.log(Level.INFO, "------------------ Info about thisJoinPoint  start ------------------");
	    LOGGER.log(Level.INFO, "Signature of thisEnclosingJoinPointStaticPart : "+thisEnclosingJoinPointStaticPart.getSignature());
	    LOGGER.log(Level.INFO, "Source location of thisEnclosingJoinPointStaticPart : "+thisEnclosingJoinPointStaticPart.getSourceLocation());
	    LOGGER.log(Level.INFO, "------------------ Info about thisEnclosingJoinPointStaticPart  ends ------------------");
		Double price= proceed();
		StringWriter log = new StringWriter();
		new Exception("Just for logging call stack").printStackTrace(new PrintWriter(log));
		System.out.println(log.toString());
		
		 StackTraceElement[] elements=new Exception().getStackTrace();
		 System.out.println("Stack Trace starting till this method");
		 System.out.println("--------------------------------------");
		 int cursorCount=0;
		 String underScore="";
		 String emptyString="";
		 for(int i=elements.length-1,j=0;i>=0;i--,j++){
			 cursorCount=j;
			 while(cursorCount>0){
				 underScore=underScore+"---";
				 emptyString=emptyString+"  ";
				 cursorCount--;
			 }
			 System.out.println(underScore+"> "+elements[i].toString());
			 System.out.println(emptyString+"|");
		 }
		 System.out.println("--------------------------------------");
		 System.out.println("Stack Trace ends till this method");
		LOGGER.log(Level.INFO, "Price retrived");
		return price;
	}*/
	
	pointcut getPriceOnCall() : call(Double com.test.java.Vehicle.getPrice());
	Double around(): getPriceOnCall(){
		System.out.println("this: " + thisJoinPoint.getThis());
		LOGGER.log(Level.INFO, "just after call and before starting execution");
		Double price= proceed();
		LOGGER.log(Level.INFO, "preceed called");
		return price;
	}
	
	pointcut getExcatModel():call(String com.test.java.MercClassA.getExactModel()) && withincode(String com.test.java.Vehicle.getModel());
	
	String around(): getExcatModel(){
		System.out.println("inside aspect getExcatModel()");
		String m = proceed();
		if(m==null){
			return "Class B";
		}
		return m;
	}
	
}
