package com.toptal.test;

import java.util.ArrayList;
import java.util.List;

public class Conversion {

	public static void main(String[] args) {
		Conversion conversion = new Conversion();
		int[] A = { 1, 0, 0, 1, 1 };
		conversion.solution(A);
	}

	public Integer[] solution(int[] A) {
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum = sum + (A[i] * Double.valueOf(Math.pow(-2, i)).intValue());
		}
		int neg = -sum;
		sum = 0;
		List<Integer> li = new ArrayList<Integer>();
		int count = 0;
		while (true) {
			sum = sum + (1 * Double.valueOf(Math.pow(-2, count)).intValue());
			if (sum == neg) {
				return li.toArray(new Integer[0]);
			}
		}
	}
}
