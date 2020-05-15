package com.chandra.algorithms.dp;

import java.util.Arrays;

public class NumberOfWaysToMakeChange {

	public static void main(String[] args) {
		int n = 7;
		int[] denoms = { 2, 3, 4, 7 };

		System.out.println(numberOfWaysToMakeChange(n, denoms));
		
		System.out.println(minNumberOfCoinsForChange(n, denoms));
	}

	public static int numberOfWaysToMakeChange(int n, int[] denoms) {
		// Write your code here.

		int[] ways = new int[n + 1];
		ways[0] = 1;

		for (int denom : denoms) {
			for (int amount = 1; amount < n + 1; amount++) {
				if (denom <= amount) {
					ways[amount] += ways[amount - denom];
				}
			}
		}
		return ways[n];
	}

	public static int minNumberOfCoinsForChange(int n, int[] denoms) {

		int[] numOfCoins = new int[n + 1];
		Arrays.fill(numOfCoins, Integer.MAX_VALUE);
		numOfCoins[0] = 0;
		int toCompare = 0;
		for (int denom : denoms) {
			for (int amount = 0; amount < numOfCoins.length; amount++) {
				if (denom <= amount) {
					if (numOfCoins[amount - denom] == Integer.MAX_VALUE) {
						toCompare = numOfCoins[amount - denom];
					} else {
						toCompare = numOfCoins[amount - denom] + 1;
					}
					numOfCoins[amount] = Math.min(numOfCoins[amount], toCompare);
				}
			}
		}

		return numOfCoins[n] != Integer.MAX_VALUE ? numOfCoins[n] : -1;
	}

}
