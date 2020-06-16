package com.chandra.algorithms.interview.Easy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

//This file is initialized with a code version of this
//question's sample test case. Feel free to add, edit,
//or remove test cases in this file as you see fit!

import java.util.*;

class TestProductSum {

	  @Test
	  public void TestCase1() {
	    List<Object> test =
	        new ArrayList<Object>(
	            Arrays.asList(
	                5,
	                2,
	                new ArrayList<Object>(Arrays.asList(7, -1)),
	                3,
	                new ArrayList<Object>(
	                    Arrays.asList(6, new ArrayList<Object>(Arrays.asList(-13, 8)), 4))));
	    assertTrue(ProductSum.productSum(test) == 12);
	  }


}
