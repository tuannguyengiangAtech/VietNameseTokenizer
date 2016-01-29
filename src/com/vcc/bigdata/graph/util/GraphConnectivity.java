
package com.vcc.bigdata.graph.util;

import com.vcc.bigdata.graph.IGraph;
import com.vcc.bigdata.graph.search.GraphDFS;


public class GraphConnectivity {

	/**
	 * Get the number of connected components of the graph. We use the DFS
	 * algorithm to visit all connected components.
	 * 
	 * @param graph
	 * @return the number of components of the graph
	 */
	public static int countComponents(IGraph graph) {
		GraphDFS graphDFS = new GraphDFS(graph);
		return graphDFS.components();
	}

	/**
	 * Check the connectivity between two given vertices.
	 * 
	 * @param graph
	 * @param u
	 * @param v
	 * @return <code>true</code> or <code>false</code>
	 */
	public static boolean isConnected(IGraph graph, int u, int v) {
		// search the graph with u is the start vertex.
		GraphDFS graphDFS = new GraphDFS(graph, u);
		// test to see if u and v is in the same connected
		// component or not.
		int[] componentId = graphDFS.getComponentId();
		return (componentId[u] == componentId[v]);
	}

	/**
	 * Get all isolated vertices of a graph.
	 * @param graph
	 * @return An array of isolated vertices. A vertex is called isolated if it
	 *         does not have an intransition.
	 */
	public static int[] getIsolatedVertices(IGraph graph) {
		int nV = graph.getNumberOfVertices();
		int[] vertices = new int[nV];

		int n = 0;
		for (int u = 0; u < nV; u++) {
			// Is u isolated?
			boolean isolated = true;
			for (int v = 0; v < nV; v++)
				if (graph.edge(v, u)) {
					isolated = false;
				}
			if (isolated) {
				vertices[n++] = u;
			}
		}
		int[] isolatedVertices = new int[n];
		for (int i = 0; i < n; i++) {
			isolatedVertices[i] = vertices[i];
		}
		return isolatedVertices;
	}
}
