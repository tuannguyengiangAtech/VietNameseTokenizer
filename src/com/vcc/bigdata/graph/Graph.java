/**
 * (C) Nguyen Giang Tuan, tuannguyengiang@admicro.vn
 *  VC Corp , Ha Noi, Viet Nam
 */

package com.vcc.bigdata.graph;

import com.vcc.bigdata.graph.util.VertexIterator;

/**
 * @author Nguyen Giang Tuan, tuannguyengiang@admicro.vn
 *         <p>
 *         Jan 19, 2016, 9:50:34 PM
 *         <p>
 *         An iterator that examines a list of outcoming edges of a vertex in an
 *         adjacency list graph.
 */
public abstract class Graph implements IGraph {
	/**
	 * The graph is directed or undirected.
	 */
	protected boolean directed;
	/**
	 * Number of vertices.
	 */
	protected int cV;

	/**
	 * Number of edges.
	 */
	protected int cE;

	/**
	 * Constructor.
	 * 
	 * @param n
	 *            number of vertices of the graph.
	 * @param directed
	 *            <code>true/false</code>
	 */
	public Graph(int n, boolean directed) {
		this.directed = directed;
		cV = n;
		cE = 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vcc.graph.IGraph#edge(int, int)
	 */
	public abstract boolean edge(int u, int v);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vcc.graph.IGraph#getNumberOfEdges()
	 */
	public int getNumberOfEdges() {
		return cE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vcc.graph.IGraph#getNumberOfVertices()
	 */
	public int getNumberOfVertices() {
		return cV;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vcc.graph.IGraph#insert(com.vcc.graph.Edge)
	 */
	public abstract void insert(Edge edge);
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vcc.graph.IGraph#isDirected()
	 */
	public boolean isDirected() {
		return directed;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vcc.graph.IGraph#iterator(int)
	 */
	public abstract VertexIterator vertexIterator(int u);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vcc.graph.IGraph#remove(com.vcc.graph.Edge)
	 */
	public abstract void remove(Edge edge);
	
	/**
	 * Dispose the graph.
	 */
	protected abstract void dispose();
}
