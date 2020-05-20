package com.chandra.algorithms.linkedlist;

// Doubly LinkedList class that has a head and tail, both of which point
// to either a linked list Node or None/null. The class supports
// setting the head and tail of the linked list
// inserting nodes before and after nodes as well as at given postitions
// removing given node and removing nodes with given values
// search for nodes with given values

public class LinkedListConstruction {

	static class Node {
		public int value;
		public Node prev;
		public Node next;

		public Node(int value) {
			this.value = value;
		}
	}

	static class DoublyLinkedList {
		public Node head;
		public Node tail;

		// O(1) time | O(1) space
		public void setHead(Node node) {
			// Write your code here.
			if (head == null) {
				head = node;
				tail = node;
				return;
			}
			insertBefore(head, node);
		}

		// O(1) time | O(1) space
		public void setTail(Node node) {
			// Write your code here.
			if (head == null) {
				setHead(node);
				return;
			}
			insertAfter(tail, node);
		}

		// O(1) time | O(1) space
		public void insertBefore(Node node, Node nodeToInsert) {
			if (nodeToInsert == head && nodeToInsert == tail)
				return;
			remove(nodeToInsert);
			nodeToInsert.prev = node.prev;
			nodeToInsert.next = node;

			if (node.prev == null) {
				head = nodeToInsert;
			} else {
				node.prev.next = nodeToInsert;
			}
			node.prev = nodeToInsert;
		}

		// O(1) time | O(1) space
		public void insertAfter(Node node, Node nodeToInsert) {
			if (nodeToInsert == head && nodeToInsert == tail)
				return;
			remove(nodeToInsert);
			nodeToInsert.prev = node;
			nodeToInsert.next = node.next;

			if (node.next == null) {
				tail = nodeToInsert;
			} else {
				node.next.prev = nodeToInsert;
			}
			node.next = nodeToInsert;
		}

		// O(p) time | O(1) space
		public void insertAtPosition(int position, Node nodeToInsert) {
			if (position == 1) {
				setHead(nodeToInsert);
				return;
			}

			Node node = head;
			int currentPosition = 1;
			while (node != null && currentPosition++ != position)
				node = node.next;

			if (node != null) {
				insertBefore(node, nodeToInsert);
			} else {
				setTail(nodeToInsert);
			}
		}

		public void removeNodesWithValue(int value) {
			Node node = head;

			while (node != null) {
				Node nodeToRemove = node;
				node = node.next;
				if (nodeToRemove.value == value)
					remove(nodeToRemove);
			}
		}

		// O(1) time | O(1) space
		public void remove(Node node) {
			if (node == head)
				head = head.next;
			if (node == tail)
				tail = tail.prev;
			removeNodeBindings(node);
		}

		// O(n) time | O(1) space
		public boolean containsNodeWithValue(int value) {
			Node node = head;
			while (node != null && node.value != value)
				node = node.next;
			return node != null;
		}

		public void removeNodeBindings(Node node) {
			if (node.prev != null)
				node.prev.next = node.next;
			if (node.next != null)
				node.next.prev = node.prev;

			node.prev = null;
			node.next = null;
		}
	}

	public static void main(String[] args) {
		DoublyLinkedList dlist = new DoublyLinkedList();
		
		dlist.setHead(new Node(10));
		dlist.insertAfter(dlist.head, new Node(2));
		dlist.insertAfter(dlist.head, new Node(3));
		dlist.insertAfter(dlist.head, new Node(4));
		dlist.insertAfter(dlist.head, new Node(5));

		Node node = dlist.head;
		while(node != null) {
			System.out.println(node.value);
			node = node.next;
			
		}
	}

}
