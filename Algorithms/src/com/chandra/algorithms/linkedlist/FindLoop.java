package com.chandra.algorithms.linkedlist;

// To find the loop in singly linked list

public class FindLoop {

	// Link list node / 
	static class LinkedList {
		int value;
		LinkedList next = null;

		public LinkedList(int value) {
			this.value = value;
		}

	}

	// Driver code 
	public static void main(String[] args) {
		LinkedList first = new LinkedList(0);

		insertAfter(first, new LinkedList(9));
		insertAfter(first, new LinkedList(8));
		insertAfter(first, new LinkedList(7));
		insertAfter(first, new LinkedList(6));
		insertAfter(first, new LinkedList(5));
		insertAfter(first, new LinkedList(4));
		insertAfter(first, new LinkedList(3));
		insertAfter(first, new LinkedList(2));
		insertAfter(first, new LinkedList(1));

		int totalCnts = countNodes(first);

		System.out.print("\nGiven list\n");
		printList(first, totalCnts);

		int k = 4;

		LinkedList head = makeloop(first, k);

		System.out.print("\nModified list\n");
		printList(head, totalCnts);
		
		LinkedList loop = findLoop(head);
		
		
		System.out.print("\nLoop list\n");
		printList(loop, k);

	}

	// Function to make loop at k-th elements of
	// linked list /
	static LinkedList makeloop(LinkedList head_ref, int k) {
		// traverse the linked list until loop
		// point not found
		LinkedList temp = head_ref;
		int count = 1;
		while (count < k) {
			temp = temp.next;
			count++;
		}

		// backup the joint point
		LinkedList joint_point = temp;

		// traverse remaining nodes
		while (temp.next != null)
			temp = temp.next;

		// joint the last node to k-th element
		temp.next = joint_point;
		return head_ref;
	}

	// O(1) time | O(1) space
	public static void insertAfter(LinkedList node, LinkedList nodeToInsert) {
		if (node == null)
			return;

		nodeToInsert.next = node.next;
		node.next = nodeToInsert;

	}

	public static int countNodes(LinkedList ptr) {
		int count = 0;
		while (ptr != null) {
			ptr = ptr.next;
			count++;
		}
		return count;
	}

	// Function to print linked list /
	static void printList(LinkedList head, int total_nodes) {
		LinkedList curr = head;
		int count = 0;
		while (count < total_nodes) {
			count++;
			System.out.print(curr.value + " ");
			curr = curr.next;
		}
	}

	// Function to find loop in a linked list 
	public static LinkedList findLoop(LinkedList head) {
		// first pointer traverse every node
		// F -> X -> D + P
		LinkedList first = head.next;
		// second pointer skips every other node
		// S -> 2X -> 2D + 2P
		LinkedList second = head.next.next;

		while (first != second) {
			first = first.next;
			second = second.next.next;
		}

		// T = 2D + P
		// R = T - P - D
		// R = 2D + P - P - D 
		// R = D
		first = head;
		while (first != second) {
			first = first.next;
			second = second.next;
		}
		return first;
	}

}
