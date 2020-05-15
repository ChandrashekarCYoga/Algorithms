package com.chandra.algorithms.interview.Easy;

// Given a sorted linked list, 
// delete all duplicates such that each element appear only once.

public class RemoveDuplicates {

	// Definition for singly-linked list.
	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		ListNode list = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3, null)))));

		deleteDuplicates(list);
		
		System.out.println(list);
	}

	public static ListNode deleteDuplicates(ListNode head) {
		ListNode current = head;

		while (current != null && current.next != null) {

			if (current.next.val == current.val) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}
		return head;
	}
}
