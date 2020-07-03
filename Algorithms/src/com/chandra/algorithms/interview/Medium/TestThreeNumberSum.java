package com.chandra.algorithms.interview.Medium;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class TestThreeNumberSum {

	@Test
	void testThreeNumberSum() {
		List<Integer[]> expected = new ArrayList<Integer[]>();
		expected.add(new Integer[] { -8, 2, 6 });
		expected.add(new Integer[] { -8, 3, 5 });
		expected.add(new Integer[] { -6, 1, 5 });
		List<Integer[]> output = ThreeNumberSum.threeNumberSum(new int[] { 12, 3, 1, 2, -6, 5, -8, 6 }, 0);
		assertTrue(this.compare(output, expected));

	}

	private boolean compare(List<Integer[]> triplets1, List<Integer[]> triplets2) {
		if (triplets1.size() != triplets2.size())
			return false;
		for (int i = 0; i < triplets1.size(); i++) {
			if (!Arrays.equals(triplets1.get(i), triplets2.get(i))) {
				return false;
			}
		}
		return true;
	}
}
