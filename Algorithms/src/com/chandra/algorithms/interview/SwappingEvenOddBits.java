/**
 * Given an unsigned 8-bit integer, swap its even and odd bits. 
 * The 1st and 2nd bit should be swapped, the 3rd and 4th bit should be swapped, 
 * and so on. For example, 10101010 should be 01010101 
 *
 * @author Chandrashekar C, chandrashekar.c@gmail.com
 */
package com.chandra.algorithms.interview;

public class SwappingEvenOddBits {

	public static void main(String[] args) {
		int x = 0x55;
		int swapBits = swapBits(x);
		System.out.println(Integer.toHexString(swapBits));
		System.out.println(Integer.toBinaryString(swapBits));
		
		x = 0xAA;
	    swapBits = swapBits(x);
		System.out.println(Integer.toHexString(swapBits(x)));
		System.out.println(Integer.toBinaryString(swapBits));
	}

	// These are all constant time, since the integer is a constant number of bits (8).
	// We can do this faser by applying a bitmask over all the even bits, and another 
	// one over all the odd bits. Then we shift the even bitmask right by one and the 
	// odd bitmask left by one.
	private static int swapBits(int x) {
		int ODD = 0x55;
		int EVEN = 0xAA;

		return (x & EVEN) >> 1 | (x & ODD) << 1;
	}
}
