package com.chandra.algorithms.interview.Easy;

import java.util.*;

public class DepthFirst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Do not edit the class below except
	// for the depthFirstSearch method.
	// Feel free to add new properties
	// and methods to the class.
	static class Node {
		String name;
		List<Node> children = new ArrayList<Node>();

		public Node(String name) {
			this.name = name;
		}

		public List<String> depthFirstSearch(List<String> array) {
			array.add(this.name);
			for (int i = 0; i < children.size(); i++) {
				children.get(i).depthFirstSearch(array);
			}
			return array;
		}

		public Node addChild(String name) {
			Node child = new Node(name);
			children.add(child);
			return this;
		}
	}

}
