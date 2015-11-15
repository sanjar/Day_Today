package com.sanjar.hacker.earth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CakeCut {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String noOfTestCases = br.readLine();
        int N = Integer.parseInt(noOfTestCases);
        for (int i = 0; i < N; i++) {
        	String[] line = br.readLine().split(" ");
        	int r = Integer.valueOf(line[0]);
        	int l = Integer.valueOf(line[1]);
        	int b = Integer.valueOf(line[2]);
        	
        	Double areaOfSquare = Double.valueOf(2*r*r);
        	Double x = 0.0;
        	if(l<r/Math.sqrt(2) && l<r/Math.sqrt(2)){
        		x = areaOfSquare/(l*b);
        	}
        	else{
        		x = (areaOfSquare/(l*b))-1;
        	}
        	
        	if(x.intValue()==0 && x.intValue()%2==0){
        		System.out.println("EQUAL");
        	}
        	else{
        		System.out.println("ALICE");
        	}
        }
	}
}
