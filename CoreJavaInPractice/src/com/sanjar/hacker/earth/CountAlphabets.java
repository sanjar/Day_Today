package com.sanjar.hacker.earth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountAlphabets {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String line = br.readLine();
       int[] arr = new int[26];
      
		int val=0;
		for(int i =0; i<line.length();i++){
			if(String.valueOf(line.charAt(i)).isEmpty() || !Character.isAlphabetic(line.charAt(i))){
				continue;
			}
			
			if(Character.isLowerCase(line.charAt(i))){
				val = Integer.valueOf(line.charAt(i))-97;
				arr[val]= arr[val]+1;
			}
			else {
				val = Integer.valueOf(line.charAt(i))-65;
				arr[val]= arr[val]+1;
			}
			
		}
		for(int num : arr){
			System.out.print(num+" ");
		}
	}
}
