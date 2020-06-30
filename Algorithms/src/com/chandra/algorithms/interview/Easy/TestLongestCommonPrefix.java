package com.chandra.algorithms.interview.Easy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestLongestCommonPrefix {

	@Test
	void testLongestCommonPrefix() {
		assertTrue(LongestCommonPrefix.longestCommonPrefix(new String[] { "flower", "flow", "flight" }).equals("fl"));
	}

	@Test
	void testLongestCommonPrefix1() {
		assertTrue(LongestCommonPrefix.longestCommonPrefix(new String[] { "dog","racecar","car" }).equals(""));
	}
}
