
package com.vcc.bigdata.graph.util;

import com.vcc.bigdata.graph.AdjacencyListGraph;
import com.vcc.bigdata.graph.AdjacencyMatrixGraph;
import com.vcc.bigdata.graph.Edge;
import com.vcc.bigdata.graph.IGraph;
import com.vcc.bigdata.graph.IWeightedGraph;


public class GraphUtilities {

	/**
	 * Extract edges of a graph.
	 * 
	 * @param graph
	 *            a graph
	 * @return an array of edges of the graph.
	 */
	public static Edge[] getEdges(IGraph graph) {
		Edge[] edges = new Edge[graph.getNumberOfEdges()];
		int e = 0;
		for (int u = 0; u < graph.getNumberOfVertices(); u++) {
			// get all vertices adjacent to u
			VertexIterator iterator = graph.vertexIterator(u);
			while (iterator.hasNext()) {
				int v = iterator.next();
				// create an edge (u,v)
				// we don't count for a loop edge of type (u,u)
				if (graph.isDirected() || u < v) {
					edges[e++] = new Edge(u, v);
				}
			}
		}
		return edges;
	}

	/**
	 * Extract edges of a weighted graph.
	 * 
	 * @param graph
	 *            a weighted graph
	 * @return an array of edges.
	 */
	public static Edge[] getWeightedEdges(IWeightedGraph graph) {
		Edge[] edges = new Edge[graph.getNumberOfEdges()];
		int e = 0;
		for (int u = 0; u < graph.getNumberOfVertices(); u++) {
			// get all edges adjacent to u
			EdgeIterator iterator = graph.edgeIterator(u);
			while (iterator.hasNext()) {
				Edge edge = iterator.next();
				if (graph.isDirected() || u < edge.getV()) {
					edges[e++] = edge;
				}
			}
		}
		return edges;
	}

	/**
	 * Copy a graph.
	 * 
	 * @param g
	 *            a graph
	 * @param dense
	 *            the returned graph is a dense one or not.
	 * @return a dense graph that is implemented by an adjacency matrix graph or
	 * @see AdjacencyMatrixGraph
	 */
	public static IGraph copy(IGraph g, boolean dense) {
		int n = g.getNumberOfVertices();
		// create an appropriate graph
		IGraph graph = null;
		if (dense) {
			graph = new AdjacencyMatrixGraph(n, g.isDirected());
		} else {
			graph = new AdjacencyListGraph(n, g.isDirected());
		}
		// fill its edges
		for (int u = 0; u < n; u++)
			for (int v = 0; v < n; v++)
				if (g.edge(u, v)) {
					graph.insert(new Edge(u, v));
				}
		return graph;
	}
}
