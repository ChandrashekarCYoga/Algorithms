package com.chandra.algorithms.interview.Easy;

import java.util.Arrays;

// How Many Apples Can You Put into the Basket
//You have some apples, where arr[i] is the weight of the i-th apple.  You also have a basket that can carry up to 5000 units of weight.
//
//Return the maximum number of apples you can put in the basket.

//Example 1:
//
//Input: arr = [100,200,150,1000]
//Output: 4
//Explanation: All 4 apples can be carried by the basket since their sum of weights is 1450.
//Example 2:
//
//Input: arr = [900,950,800,1000,700,800]
//Output: 5
//Explanation: The sum of weights of the 6 apples exceeds 5000 so we choose any 5 of them.

public class maxNumberOfApples {

	public static void main(String[] args) {

		System.out.println(maxNumberOfApplesinBasket(new int[] { 100, 200, 150, 1000 }));
		System.out.println(maxNumberOfApplesinBasket(new int[] { 900,950,800,1000,700,800 }));

	}

	private static int maxNumberOfApplesinBasket(int[] arr) {
		int max = 5000;
		int total = 0;
		int i = 0;

		Arrays.sort(arr);

		while (i < arr.length) {
			total += arr[i];
			if (total < max)
				i++;
			else
				break;
		}

		return i;
	}

}
