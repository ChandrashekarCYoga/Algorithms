package com.chandra.algorithms.interview.Easy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestBinarySearch {

	@Test
	public void TestCase1() {
		assertTrue(BinarySearch.binarySearch(new int[] { 0, 1, 21, 33, 45, 45, 61, 71, 72, 73 }, 33) == 3);
	}

	@Test
	public void TestCase2() {
		assertTrue(BinarySearch.binarySearchR(new int[] { 0, 1, 21, 33, 45, 45, 61, 71, 72, 73 }, 33) == 3);
	}
}
