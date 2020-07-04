package com.chandra.algorithms.interview.Medium;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class TestSmallestDifference {

	@Test
	void test() {
	    int[] expected = {28, 26};
	    assertTrue(
	        Arrays.equals(
	            SmallestDifference.smallestDifference(
	                new int[] {-1, 5, 10, 20, 28, 3}, new int[] {26, 134, 135, 15, 17}),
	            expected));


	}

}
