/**
 * (C) Nguyen Giang Tuan, tuannguyengiang@admicro.vn
 *  VC Corp , Ha Noi, Viet Nam
 */
package com.vcc.bigdata.graph;

/**
 * @author Nguyen Giang Tuan, tuannguyengiang@admicro.vn
 *         <p>
 *         Jan 19, 2016, 9:50:34 PM
 *         <p>
 *         An iterator that examines a list of outcoming edges of a vertex in an
 *         adjacency list graph.
 */
public class Edge implements Comparable<Edge> {
	private final int u;
	private final int v;
	private double weight;

	/**
	 * Constructor.
	 * 
	 * @param u
	 * @param v
	 */
	public Edge(int u, int v) {
		this.u = u;
		this.v = v;
		this.weight = 0;
	}

	/**
	 * Constructor
	 * 
	 * @param u
	 * @param v
	 * @param weight
	 */
	public Edge(int u, int v, double weight) {
		this(u, v);
		this.weight = weight;
	}

	/**
	 * Get the source vertex.
	 * 
	 * @return source vertex
	 */
	public int getU() {
		return u;
	}

	/**
	 * Get the target vertex.
	 * 
	 * @return the target vertex.
	 */
	public int getV() {
		return v;
	}

	/**
	 * Get the weight of the edge.
	 * 
	 * @return the weight.
	 */
	public double getWeight() {
		return weight;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Edge) {
			Edge e = (Edge) obj;
			return (u == e.getU() && v == e.getV());
		}
		return false;
	}

	@Override
	public String toString() {
		return getU() + " - " + getV() + ": " + getWeight();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Edge o) {
		double diff = getWeight() - o.getWeight();
		if (diff == 0)
			return 0;
		else if (diff > 0)
			return 1;
		else
			return -1;
	}
}
