package com.chandra.algorithms.linkedlist;

// Invert a binary tree.
import java.util.LinkedList;
import java.util.Queue;

// Input:
//     4
//   /   \
//  7     2
// / \   / \
//9   6 3   1

// Output:
//     4
//   /   \
//  7     2
// / \   / \
//9   6 3   1 

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class InvertTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4, new TreeNode(7, new TreeNode(9, null, null), new TreeNode(6, null, null)),
				new TreeNode(2, new TreeNode(3, null, null), new TreeNode(1, null, null)));

		System.out.println("Before Inverting");
		printInOrder(root);

		invertTree(root);

		System.out.println("After Inverting");
		printInOrder(root);

	}

	// Definition for a binary tree node.
	private static void printInOrder(TreeNode root) {
		if (root == null)
			return;

		printInOrder(root.left);
		System.out.println(root.val);
		printInOrder(root.right);

	}

//	
// Approach #1 (Recursive) 
//
// This is a classic tree problem that is best-suited for a recursive approach.
// Algorithm. 
// The inverse of an empty tree is the empty tree. The inverse of a tree with root 
// r, and subtrees {right} and {left}, is a tree with root r, whose right subtree is 
// the inverse of {left}, and whose left subtree is the inverse of {right}.
	
//	Complexity Analysis
//
//	Since each node in the tree is visited only once, the time complexity is 
//	
//	O(n), where n is the number of nodes in the tree

	public TreeNode invertTreeRecursive(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode right = invertTree(root.right);
		TreeNode left = invertTree(root.left);
		root.left = right;
		root.right = left;
		return root;
	}

	
// Approach #2 (Iterative) 
//
// Alternatively, we can solve the problem iteratively, in a manner similar to breadth-first search.
//
// Algorithm
//
// The idea is that we need to swap the left and right child of all nodes in the tree. 
// So we create a queue to store nodes whose left and right child have not been swapped yet. 
// Initially, only the root is in the queue. As long as the queue is not empty, remove the next 
// node from the queue, swap its children, and add the children to the queue. Null nodes are not 
// added to the queue. Eventually, the queue will be empty and all the children swapped, and we 
// return the original root.
		
		
//	Complexity Analysis
//
//	Since each node in the tree is visited / added to the queue only once, the time complexity is 
//
//	O(n), where n is the number of nodes in the tree.
	
	private static TreeNode invertTree(TreeNode root) {
		if (root == null)
			return null;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode current = queue.poll();
			TreeNode temp = current.left;
			current.left = current.right;
			current.right = temp;

			if (current.left != null)
				queue.add(current.left);
			if (current.right != null)
				queue.add(current.right);
		}

		return root;
	}

}
