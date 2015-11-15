package com.sanjar.hacker.earth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AdjacentDiffOne {

	public static void main(String[] args) throws IOException {
		permutation();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	       String line = br.readLine();
	       
	       for(int i =0;i<Integer.parseInt(line);i++){
	    	   String line1 = br.readLine();
	    	   for(int j=0;j<Integer.parseInt(line1);j++){
	    		   
	    	   }
	       }
	}
	
	public static void  permutation(){
		//int N = Integer.parseInt(args[0]);
        int[] a = {1,2,3,4};

        // insert integers 0..N-1
        for (int i = 0; i < a.length; i++)
            a[i] = i;

        // shuffle
        for (int i = 0; i < a.length; i++) {
            int r = (int) (Math.random() * (i+1));     // int between 0 and i
            int swap = a[r];
            a[r] = a[i];
            a[i] = swap;
        }

        // print permutation
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println("");

        // print checkerboard visualization
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[j] == i) System.out.print("* ");
                else           System.out.print(". ");
            }
            System.out.println("");
        }
    }
	
}
