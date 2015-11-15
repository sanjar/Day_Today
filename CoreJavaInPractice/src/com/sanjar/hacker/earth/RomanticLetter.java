package com.sanjar.hacker.earth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RomanticLetter {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String noOfTestCases = br.readLine();
        int N = Integer.parseInt(noOfTestCases);
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < N; i++) {
        	String encryptMessage = br.readLine();
        	for(int j =0;j<encryptMessage.length();j++){
        		int v = 26 - (encryptMessage.charAt(0)-'a');
        		if((encryptMessage.charAt(j)+v)>122){
        			//char[] c = Character.toChars((encryptMessage.charAt(j)+v)-26);
        			char c = (char) ((encryptMessage.charAt(j)+v)-26);
        			sb.append(c);
        		}
        		else{
        			char c = (char) (encryptMessage.charAt(j)+v);
        		sb.append(c);
        		}
        	}
        	System.out.println(sb);
        	sb.setLength(0);
        }
	}
}
