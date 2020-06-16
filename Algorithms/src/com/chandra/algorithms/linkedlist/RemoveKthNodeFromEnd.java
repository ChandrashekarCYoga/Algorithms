package com.chandra.algorithms.linkedlist;

public class RemoveKthNodeFromEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList first = new LinkedList(10);
		first.next = new LinkedList(9);
		first.next.next = new LinkedList(8);
		first.next.next.next = new LinkedList(7);

		System.out.println("Before removing kth Node");
		
		LinkedList node = first;
		while(node != null) {
			System.out.println(node.value + ":");
			node = node.next;
			
		}
		
		removeKthNodeFromEnd(first, 3);
		
		node = first;
		System.out.println("After removing kth Node");
		while(node != null) {
			System.out.println(node.value + ":");
			node = node.next;
		}
	}

	// O(n) time | O(1) space
	public static void removeKthNodeFromEnd(LinkedList head, int k) {

		LinkedList first = head;
		LinkedList second = head;
		int counter = 1;

		while (counter <= k) {
			second = second.next;
			counter++;
		}

		if (second == null) {
			head.value = head.next.value;
			head.next = head.next.next;
			return;
		}

		while (second.next != null) {
			second = second.next;
			first = first.next;
		}

		first.next = first.next.next;
	}

	static class LinkedList {
		int value;
		LinkedList next = null;

		public LinkedList(int value) {
			this.value = value;
		}
	}

}
