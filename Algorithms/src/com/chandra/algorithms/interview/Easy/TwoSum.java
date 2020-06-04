/**
 * Given a list of numbers and a number k, return whether any two numbers 
 * from the list add up to k.
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 * 
 * One-pass Hash Table
 *
 * @author Chandrashekar C, chandrashekar.c@gmail.com
 */
package com.chandra.algorithms.interview.Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {

		int[] list = { 10, 15, 3, 7 };

		int k = 17;

		System.out.println(isFound(list, k));

		int[] list1 = { 2, 7, 11, 15 };
		k = 9;

		System.out.println(isFound(list1, k));

		int[] list2 = { 3, 5, -4, 8, 11, 1, -1, 6 };
		int targetSum = 10;
		System.out.println(Arrays.toString(twoNumberSum(list2, targetSum)));

	}

	// While we iterate and inserting elements into the table, we also look
	// back to check if current element's complement already exists in the table.
	// If it exists, we have found a solution and return immediately.

	private static boolean isFound(int[] list, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < list.length; i++) {
			int complement = k - list[i];
			if (map.containsKey(complement)) {
				return true;
			}
			map.put(list[i], i);
		}
		return false;
	}

	// O(n^2) time | O(1) space
	public static int[] twoNumberSum(int[] array, int targetSum) {
		for (int i = 0; i < array.length - 1; i++) {
			int firstNum = array[i];
			for (int j = i + 1; j < array.length; j++) {
				int secondNum = array[j];
				if (firstNum + secondNum == targetSum) {
					return new int[] { firstNum, secondNum };
				}
			}
		}
		return new int[0];
	}

}
