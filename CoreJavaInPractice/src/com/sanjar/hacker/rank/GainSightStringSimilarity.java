package com.sanjar.hacker.rank;

import java.util.Arrays;

public class GainSightStringSimilarity {

	static int[] integers;

	public static void main(String[] args) throws InterruptedException {
		String[] inputs = { "ababaa", "aa" };
		System.out.println(Arrays.toString(StringSimilarity(inputs)));

	}

	static int[] StringSimilarity(String[] inputs) throws InterruptedException {
		integers = new int[inputs.length];

		for (int j = 0; j < inputs.length; j++) {

			Thread t = new Thread(
					new GainSightStringSimilarity().new StringSimilarityThread(
							inputs[j], j));
			t.start();
			t.join();
			// System.out.println(input.length() + count);
			// count = 0;
		}

		return integers;

	}

	class StringSimilarityThread implements Runnable {

		private String input;
		private int position;

		public StringSimilarityThread(String input, int position) {
			this.input = input;
			this.position = position;
		}

		@Override
		public void run() {
			int count = 0;
			for (int i = 1; i < input.length(); i++) {
				count = count
						+ getStringSimilarityCount(input.substring(i), input);
			}
			integers[position] = input.length() + count;

		}

	}

	static int getStringSimilarityCount(String smallerString,
			String biggerString) {
		int count = 0;
		for (int i = 0; i < smallerString.length(); i++) {
			if (smallerString.charAt(i) == biggerString.charAt(i)) {
				count++;
			} else {
				break;
			}
		}

		return count;

	}
}
