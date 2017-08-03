package com.toptal.test;

public class FindNonMatchingNumbers {

	public static void main(String[] args) {
		FindNonMatchingNumbers findNonMatchingNumbers = new FindNonMatchingNumbers();
		int A[] = { 5, 5, 1, 7, 2, 3, 5 };
		int X = 5;
		System.out.println(findNonMatchingNumbers.solution(X, A));
	}

	public int solution(int X, int[] A) {
		int count = 0;
		for (int a : A) {
			if (a != X) {
				count++;
			}
		}

		return count;
	}
}
