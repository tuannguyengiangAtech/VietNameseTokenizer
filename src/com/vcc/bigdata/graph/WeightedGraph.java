/**
 * (C) Nguyen Giang Tuan, tuannguyengiang@admicro.vn
 *  VC Corp , Ha Noi, Viet Nam
 */

package com.vcc.bigdata.graph;

import com.vcc.bigdata.graph.util.EdgeIterator;


public abstract class WeightedGraph extends Graph implements IWeightedGraph {

	/**
	 * Default constructor.
	 * @param n
	 * @param directed
	 */
	public WeightedGraph(int n, boolean directed) {
		super(n, directed);
	}
	/* (non-Javadoc)
	 * @see com.vcc.graph.IWeightedGraph#edgeIterator(int)
	 */
	public abstract EdgeIterator edgeIterator(int u);

	/* (non-Javadoc)
	 * @see com.vcc.graph.IWeightedGraph#getEdge(int, int)
	 */
	public abstract Edge getEdge(int u, int v);

}
