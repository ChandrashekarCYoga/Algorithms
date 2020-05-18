package com.chandra.algorithms.interview.Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// We are given two sentences A and B.  (A sentence is a string of space separated words.  
// Each word consists only of lowercase letters.)
//
// A word is uncommon if it appears exactly once in one of the sentences, and does not 
// appear in the other sentence.
//
// Return a list of all uncommon words. 
//
// You may return the list in any order.

//
//Example 1:
//
//Input: A = "this apple is sweet", B = "this apple is sour"
//Output: ["sweet","sour"]
//Example 2:
//
//Input: A = "apple apple", B = "banana"
//Output: ["banana"]

public class UncommonWordsfromTwoSentences {

	public static void main(String[] args) {
		String A = "this apple is sweet", B = "this apple is sour";

		System.out.println(Arrays.toString(uncommonFromSentences(A, B)));

	}

	private static String[] uncommonFromSentences(String A, String B) {
		Map<String, Integer> count = new HashMap<String, Integer>();
		for (String word : A.split(" "))
			count.put(word, count.getOrDefault(word, 0) + 1);
		for (String word : B.split(" "))
			count.put(word, count.getOrDefault(word, 0) + 1);

		List<String> ans = new LinkedList<String>();
		for (String word : count.keySet())
			if (count.get(word) == 1)
				ans.add(word);

		return ans.toArray(new String[ans.size()]);
	}

}
