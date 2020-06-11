package com.chandra.algorithms.greedy;

/*
 * Given a string s and a string t, check if s is subsequence of t.
 * A subsequence of a string is a new string which is formed from the 
 * original string by deleting some (can be none) of the characters without 
 * disturbing the relative positions of the remaining characters. (ie, "ace" is a 
 * subsequence of "abcde" while "aec" is not).
 * 
 */
public class Subsequence {

	public static void main(String[] args) {
		String s = "abc";
		String t = "ahbgdc";
		
		System.out.println(isSubsequence(s, t));
		
		s = "axc"; t = "ahbgdc";
		
		System.out.println(isSubsequence(s, t));

	}

	// Two-Pointers approach
	
	private static boolean isSubsequence(String s, String t) {
		Integer leftBound = s.length(), rightBound = t.length();
		Integer pLeft = 0, pRight = 0;

		while (pLeft < leftBound && pRight < rightBound) {
			// move both pointers or just the right pointer
			if (s.charAt(pLeft) == t.charAt(pRight)) {
				pLeft += 1;
			}
			pRight += 1;
		}
		return pLeft == leftBound;
	}

}
