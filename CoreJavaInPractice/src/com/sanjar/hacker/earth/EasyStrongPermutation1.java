package com.sanjar.hacker.earth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class EasyStrongPermutation1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	       String noOfInteger = br.readLine();
	       String[] numberStrs = br.readLine().split(" ");
	       
	       Integer[] numbers = new Integer[numberStrs.length];
	       List<Integer> integers = new ArrayList<Integer>();
	       for(int i = 0;i < numberStrs.length;i++)
	       {
	          // Note that this is assuming valid input
	          // If you want to check then add a try/catch 
	          // and another index for the numbers if to continue adding the others
	    	   integers.add(Integer.parseInt(numberStrs[i]));
	       }
	       
	       for(int i =1;i<integers.size();i++){
	    	   if(i<integers.size()-2){
		    	   int removed = integers.remove(integers.size()-1);
		    	   integers.add(i, removed);
	    	   }
	       }
	       System.out.println(calStrongPermuattion(integers));
	}
	private static int calStrongPermuattion(List<Integer> list) {
		int sum =0;
		//System.out.println(list);
		//System.out.println("-");
		for(int i =0;i<list.size()-1;i++){
			sum = sum + Math.abs(list.get(i)-list.get(i+1));
		}
		sum = sum +Math.abs(list.get(0)-list.get(list.size()-1));
		return sum;
	}
}
