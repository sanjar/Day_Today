package com.sanjar.dsa.made.easy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Generate all strings of n bits. Assume A[0... n-1] is an array of size n.
 * 
 * @author Sadique
 *
 */
public class GenerateAllStringsNBits {

	private static int[] A;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();

		A = new int[n];
		Binary(n);
		scanner.close();
	}

	static void Binary(int n) {
		if (n < 1) {
			System.out.println(Arrays.toString(A));
		} else {
			A[n - 1] = 0;
			Binary(n - 1);
			A[n - 1] = 1;
			Binary(n - 1);
		}
	}
}
