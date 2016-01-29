/**
 * (C) Nguyen Giang Tuan, tuannguyengiang@admicro.vn
 *  VC Corp , Ha Noi, Viet Nam
 */

package com.vcc.bigdata.graph;

import com.vcc.bigdata.graph.util.VertexIterator;


public interface IGraph {
	/**
	 * Get the number of vertices of the graph.
	 * @return the number of vertices of the graph.
	 */
	int getNumberOfVertices();
	/**
	 * Get the number of edges of the graph.
	 * @return the number of edges of the graph.
	 */
	int getNumberOfEdges();
	/**
	 * Check to see if the graph is directed or undirected.
	 * @return <code>true</code> if the graph is directed, <code>false</code> if 
	 * it is not.
	 */
	boolean isDirected();
	/**
	 * Insert an edge to the graph 
	 * @param edge
	 */
	void insert(Edge edge);
	/**
	 * Remove an edge from the graph.
	 * @param edge
	 */
	void remove(Edge edge);
	/**
	 * Check to see the existence of the edge (u,v).
	 * @param u
	 * @param v
	 * @return <code>true/false</code>
	 */
	boolean edge(int u, int v);
	/**
	 * Get an iterator for processing the vertices adjacent to a vertex.
	 * @param u a vertex
	 * @return an iterator of vertices adjacent to <code>u</code>.
	 */
	VertexIterator vertexIterator(int u);
}
