package com.chandra.algorithms.sorting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestBubbleSort {

	@Test
	public void TestCase1() {
		int[] expected = { 2, 3, 5, 5, 6, 8, 9 };
		int[] input = { 8, 5, 2, 9, 5, 6, 3 };
		assertTrue(compare(BubbleSort.bubbleSort(input), expected));
	}
	
	@Test
	public void TestCase2() {
		int[] expected = { 1 };
		int[] input = { 1 };
		assertTrue(compare(BubbleSort.bubbleSort(input), expected));
	}

	@Test
	public void TestCase3() {
		int[] expected = { 1, 2 };
		int[] input = { 1, 2 };
		assertTrue(compare(BubbleSort.bubbleSort(input), expected));
	}

	@Test
	public void TestCase4() {
		int[] expected = { 1, 2 };
		int[] input = { 2, 1 };
		assertTrue(compare(BubbleSort.bubbleSort(input), expected));
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
