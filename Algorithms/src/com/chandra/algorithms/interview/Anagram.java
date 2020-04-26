/**
 * An implementation to test give two strings are anagram of each other 
 *
 * @author Chandrashekar C, chandrashekar.c@gmail.com
 */
package com.chandra.algorithms.interview;

import java.util.Arrays;
import java.util.HashMap;

/*
 * An anagram is produced by rearranging the letters of s into t. Therefore, 
 * if t is an anagram of s, sorting both strings will result in two identical 
 * strings. Furthermore, if s and t have different lengths, t must not be an 
 * anagram of s and we can return early.
 */
public class Anagram {

	public static void main(String[] args) {
		System.out.println(new Anagram().isAnagram("anagram", "nagaram"));
		System.out.println(new Anagram().isAnagram1("anagram", "nagaram"));
		System.out.println(new Anagram().isAnagram2("anagram", "nagaram"));
		
	}

	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		char[] str1 = s.toCharArray();
		char[] str2 = t.toCharArray();
		Arrays.sort(str1);
		Arrays.sort(str2);
		return Arrays.equals(str1, str2);
	}

	// Time complexity is O(n) because accessing the counter table is a constant
	// time operation.
	// Although we do use extra space, the space complexity is
	// O(1) because the table's size stays constant no matter how large n is.
	public boolean isAnagram1(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] counter = new int[26];
		for (int i = 0; i < s.length(); i++) {
			counter[s.charAt(i) - 'a']++;
			counter[t.charAt(i) - 'a']--;
		}
		for (int count : counter) {
			if (count != 0) {
				return false;
			}
		}
		return true;
	}

	// Use a hash table instead of a fixed size counter. Imagine allocating a
	// large size array to fit the entire range of unicode characters, which could
	// go up to more than 1 million. A hash table is a more generic solution and
	// could adapt to any range of characters.

	public boolean isAnagram2(String s, String t) {
		HashMap<Character, Integer> smap = new HashMap<>();
		int sl = s.length();
		int tl = t.length();

		if (sl != tl)
			return false;

		for (int i = 0; i < sl; i++) {
			smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i), 0) + 1);
			smap.put(t.charAt(i), smap.getOrDefault(t.charAt(i), 0) - 1);
		}
		for (char c : smap.keySet()) {
			if (smap.get(c) != 0) {
				return false;
			}
		}

		return true;
	}

}
