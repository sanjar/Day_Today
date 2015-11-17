package com.sanjar.hacker.earth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PrintAllNumbers {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String line = br.readLine();
       List<Integer> li = new ArrayList<Integer>();
       StringBuilder n=new StringBuilder("");
		for(int i =0; i<line.length();i++){
			if(String.valueOf(line.charAt(i)).isEmpty() || !Character.isDigit(line.charAt(i))){
				if(!n.toString().isEmpty()){
					li.add(Integer.valueOf(n.toString()));
					n.setLength(0);
				}
				continue;
			}
			n.append(line.charAt(i));
			
		}
		if(!n.toString().isEmpty()){
			li.add(Integer.valueOf(n.toString()));
			n.setLength(0);
		}
		for(int num : li){
			System.out.println(num);
		}
	}
}
