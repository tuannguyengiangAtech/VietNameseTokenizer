/**
 * (C) Nguyen Giang Tuan, tuannguyengiang@admicro.vn
 *  VC Corp , Ha Noi, Viet Nam
 */
package com.vcc.bigdata.graph;

import com.vcc.bigdata.graph.util.AdjacencyMatrixVertexIterator;
import com.vcc.bigdata.graph.util.VertexIterator;

/**
 * @author Nguyen Giang Tuan, tuannguyengiang@admicro.vn
 *         <p>
 *         Jan 19, 2016, 9:50:34 PM
 *         <p>
 *         An iterator that examines a list of outcoming edges of a vertex in an
 *         adjacency list graph.
 */
public class AdjacencyMatrixGraph extends Graph {

	private final boolean adj[][];
	/**
	 * @param n
	 * @param directed
	 */
	public AdjacencyMatrixGraph(int n, boolean directed) {
		super(n, directed);
		adj = new boolean[n][n];
	}

	/* (non-Javadoc)
	 * @see com.vcc.graph.Graph#insert(com.vcc.graph.Edge)
	 */
	@Override
	public void insert(Edge edge) {
		int u = edge.getU();
		int v = edge.getV();
		if (!adj[u][v]) {
			cE++;
		}
		adj[u][v] = true;
		if (!directed) {
			adj[v][u] = true;
		}
	}

	/* (non-Javadoc)
	 * @see com.vcc.graph.Graph#iterator(int)
	 */
	@Override
	public VertexIterator vertexIterator(int u) {
		return new AdjacencyMatrixVertexIterator(this, u);
	}

	/* (non-Javadoc)
	 * @see com.vcc.graph.Graph#remove(com.vcc.graph.Edge)
	 */
	@Override
	public void remove(Edge edge) {
		int u = edge.getU();
		int v = edge.getV();
		if (adj[u][v]) {
			cE--;
		}
		adj[u][v] = false;
		if (!directed) {
			adj[v][u] = false;
		}
	}

	@Override
	public boolean edge(int u, int v) {
		return adj[u][v];
	}

	/**
	 * Get the adjacency matrix that represents the graph.
	 * @return the adjacency matrix that represents the graph.
	 */
	public boolean[][] getAdj() {
		return adj;
	}

	/* (non-Javadoc)
	 * @see com.vcc.graph.Graph#dispose()
	 */
	@Override
	protected void dispose() {
	}
	
}
