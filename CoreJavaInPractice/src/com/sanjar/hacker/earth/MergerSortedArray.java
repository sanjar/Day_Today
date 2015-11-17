package com.sanjar.hacker.earth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergerSortedArray {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        
        int sizeA = Integer.parseInt(line);
        
        String line2 = br.readLine();
        String[] arr1 = line2.split(" ");
        
        String line3 = br.readLine();
        
        int sizeB = Integer.parseInt(line3);
        
        String line4 = br.readLine();
        
        String[] arr2 = line4.split(" ");
        int[] A = new int[arr1.length];
        int[] B = new int[arr2.length];
        int[] C = new int[arr1.length+arr2.length];
        for(int i=0;i<arr1.length;i++){
        	A[i] = Integer.valueOf(arr1[i]);
        }
        for(int i=0;i<arr2.length;i++){
        	B[i] = Integer.valueOf(arr2[i]);
        }
        for(int n : merge(A, B, C)){
        	System.out.print(n+" ");
        }
	}
	
	public static int[] merge(int[] A, int[] B, int[] C) {
	      int i, j, k, m, n;
	      i = 0;
	      j = 0;
	      k = 0;
	      m = A.length;
	      n = B.length;
	      while (i < m && j < n) {
	            if (A[i] <= B[j]) {
	                  C[k] = A[i];
	                  i++;
	            } else {
	                  C[k] = B[j];
	                  j++;
	            }
	            k++;
	      }
	      if (i < m) {
	            for (int p = i; p < m; p++) {
	                  C[k] = A[p];
	                  k++;
	            }
	      } else {
	            for (int p = j; p < n; p++) {
	                  C[k] = B[p];
	                  k++;
	            }
	      }
	      return C;
	}
}
