package com.chandra.algorithms.interview.Easy;

import java.util.HashMap;

public class LongPressedName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "alex", typed = "aaleex";
		System.out.println(isLongPressedName(name, typed));

		name = "saeed";
		typed = "ssaaedd";
		System.out.println(isLongPressedName1(name, typed));
		
		name = "kikcxmvzi";
		typed = "kiikcxxmmvvzz";
		System.out.println(isLongPressedName1(name, typed));
	}

	private static boolean isLongPressedName(String name, String typed) {

		int j = 0;
		for (char c : name.toCharArray()) {
			if (j == typed.length())
				return false;

			// If mismatch...
			if (typed.charAt(j) != c) {
				// If it's the first char of the block, ans is false.
				if (j == 0 || typed.charAt(j - 1) != typed.charAt(j))
					return false;

				// Discard all similar chars
				char cur = typed.charAt(j);
				while (j < typed.length() && typed.charAt(j) == cur)
					j++;

				// If next isn't a match, ans is false.
				if (j == typed.length() || typed.charAt(j) != c)
					return false;
			}

			j++;
		}

		return true;

	}

	private static boolean isLongPressedName1(String name, String typed) {

		char[] charArray = name.toCharArray();
		char[] charArray2 = typed.toCharArray();

		HashMap<Character, Integer> N = new HashMap();
		HashMap<Character, Integer> T = new HashMap();

		for (char c : charArray) {
			N.put(c, N.getOrDefault(c, 0) + 1);
		}

		for (char c : charArray2) {
			T.put(c, T.getOrDefault(c, 0) + 1);
		}

		if (!T.keySet().equals(N.keySet()))
			return false;

		
		for(char c : N.keySet()) {
			if (N.get(c) > T.get(c))
				return false;
		}
		return true;
	}
}
