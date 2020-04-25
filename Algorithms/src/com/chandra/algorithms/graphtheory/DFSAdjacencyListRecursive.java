package com.chandra.algorithms.graphtheory;

import java.util.*;

public class DFSAdjacencyListRecursive {

	static class Edge {
		int from, to, cost;

		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}

	public static void main(String[] args) {
		int numNodes = 5;
		Map<Integer, List<Edge>> graph = new HashMap<>();
		
		 // Create a fully connected graph
	    //           (0)
	    //           / \
	    //        5 /   \ 4
	    //         /     \
	    // 10     <   -2  >
	    //   +->(2)<------(1)      (4)
	    //   +--- \       /
	    //         \     /
	    //        1 \   / 6
	    //           > <
	    //           (3)

		addDirectedEdge(graph, 0, 1, 4);
		addDirectedEdge(graph, 0, 2, 5);
		addDirectedEdge(graph, 1, 2, -2);
		addDirectedEdge(graph, 1, 3, 6);
		addDirectedEdge(graph, 2, 3, 1);
		addDirectedEdge(graph, 2, 2, 10); // Self loop
		
		long nodeCount = dfs(0, new boolean[numNodes], graph);
	    System.out.println("DFS node count starting at node 0: " + nodeCount);
	    if (nodeCount != 4) System.err.println("Error with DFS");
	    
	    nodeCount = dfs(4, new boolean[numNodes], graph);
	    System.out.println("DFS node count starting at node 4: " + nodeCount);
	    if (nodeCount != 1) System.err.println("Error with DFS");

	}

	// Perform a depth first search on the graph counting
	// the number of nodes traversed starting at some position
	static long dfs(int at, boolean[] visited, Map<Integer, List<Edge>> graph) {
		
		if(visited[at]) return 0L; 

		long count = 1;
		visited[at] = true;
		
		// Visit all edges adjacent to where we're at
	    List<Edge> edges = graph.get(at);
	    if(edges != null) {
	    	for (Edge edge : edges) {
	    		count+= dfs(edge.to, visited, graph);
	    	}
	    }
		return count;

	}

	// Helper method to setup graph
	private static void addDirectedEdge(Map<Integer, List<Edge>> graph, int from, int to, int cost) {

		List<Edge> list = graph.get(from);

		if (list == null) {
			list = new ArrayList<Edge>();
			graph.put(from, list);
		}
		list.add(new Edge(from, to, cost));
	}
}
