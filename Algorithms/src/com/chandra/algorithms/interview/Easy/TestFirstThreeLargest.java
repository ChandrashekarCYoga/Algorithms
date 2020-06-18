package com.chandra.algorithms.interview.Easy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestFirstThreeLargest {

	@Test
	void test() {
		int[] expected = { 18, 141, 541 };
		assertTrue(compare(FindThreeLargestNumbers
				.findThreeLargestNumbers(new int[] { 141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7 }), expected));

	}

	public boolean compare(int[] arr1, int[] arr2) {
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

}
