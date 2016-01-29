package com.vcc.bigdata.graph;

import com.vcc.bigdata.graph.util.EdgeIterator;

/**
 * @author Nguyen Giang Tuan, tuannguyengiang@admicro.vn
 *         <p>
 *         Jan 19, 2016, 9:50:34 PM
 *         <p>
 *         An iterator that examines a list of outcoming edges of a vertex in an
 *         adjacency list graph.
 */
public class EdgeNode {
	private final Edge e;
	private final EdgeNode next;

	/**
	 * Default constructor.
	 */
	public EdgeNode() {
		e = null;
		next = null;
	}

	/**
	 * Constructor an edge node given an edge and next edge node. 
	 * @param e an edge
	 * @param next next edge node
	 */
	public EdgeNode(Edge e, EdgeNode next) {
		this.e = e;
		this.next = next;
	}

	/**
	 * Get the next edge node.
	 * @return the next edge node.
	 */
	public EdgeNode getNext() {
		return next;
	}
	
	/**
	 * Get the edge in the current node.
	 * @return the edge.
	 */
	public Edge getEdge() {
		return e;
	}

}
