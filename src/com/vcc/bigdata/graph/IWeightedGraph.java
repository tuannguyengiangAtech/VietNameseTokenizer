/**
 * (C) Nguyen Giang Tuan, tuannguyengiang@admicro.vn
 *  VC Corp , Ha Noi, Viet Nam
 */

package com.vcc.bigdata.graph;

import com.vcc.bigdata.graph.util.EdgeIterator;


public interface IWeightedGraph extends IGraph {
	
	/**
	 * Get the edge determined by two vertices.
	 * @param u
	 * @param v
	 * @return the edge or <tt>null</tt> if there does not a such edge.
	 */
	public Edge getEdge(int u, int v);
	
	/**
	 * Get an iterator of edges that go out from a vertex
	 * @param u a vertex
	 * @return an iterator of edges.
	 */
	public EdgeIterator edgeIterator(int u);
}
