package com.vcc.bigdata.graph;

/**
 * (C) Nguyen Giang Tuan, tuannguyengiang@admicro.vn
 *  VC Corp , Ha Noi, Viet Nam
 */


import com.vcc.bigdata.graph.util.AdjacencyListVertexIterator;
import com.vcc.bigdata.graph.util.VertexIterator;

/**
 * @author Nguyen Giang Tuan, tuannguyengiang@admicro.vn
 *         <p>
 *         Jan 19, 2016, 9:50:34 PM
 *         <p>
 *         An iterator that examines a list of outcoming edges of a vertex in an
 *         adjacency list graph.
 */
public class AdjacencyListGraph extends Graph {

	private final Node adj[];
	
	/**
	 * Constructor.
	 * @param n number of vertices of the graph.
	 * @param directed <code>true/false</code>
	 */
	public AdjacencyListGraph(int n, boolean directed) {
		super(n, directed);
		adj = new Node[n];
	}
	
	/* (non-Javadoc)
	 * @see com.vcc.graph.Graph#edge(int, int)
	 */
	@Override
	public boolean edge(int u, int v) {
		VertexIterator iterator = vertexIterator(u);
		while (iterator.hasNext()) {
			int w = iterator.next();
			if (v == w) return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see com.vcc.graph.Graph#iterator(int)
	 */
	@Override
	public VertexIterator vertexIterator(int u) {
		return new AdjacencyListVertexIterator(this, u);
	}

	/* (non-Javadoc)
	 * @see com.vcc.graph.Graph#insert(com.vcc.graph.Edge)
	 */
	@Override
	public void insert(Edge edge) {
		int u = edge.getU();
		int v = edge.getV();
		// add the edge (u,v)
		adj[u] = new Node(v, adj[u]);
		// add the edge (v,u) if the graph
		// is not directed
		if (!directed) {
			adj[v] = new Node(u, adj[v]);
		}
		// increase the number of edges
		cE++;
	}

	/* (non-Javadoc)
	 * @see com.vcc.graph.IGraph#remove(com.vcc.graph.Edge)
	 */
	@Override
	public void remove(Edge edge) {
		//TODO
	}

	/**
	 * Get the adjacency list.
	 * @return the adjacency list.
	 */
	public Node[] getAdj() {
		return adj;
	}

	/* (non-Javadoc)
	 * @see com.vcc.graph.Graph#dispose()
	 */
	@Override
	protected void dispose() {
		// delete the array of linked-list.
		for (int u = 0; u < adj.length; u++) {
			dispose(adj[u]);
		}
	}

	/**
	 * Dispose a LIFO linked list headed by a node.
	 * @param node the top node of the list.
	 */
	private void dispose(Node node) {
		if (node != null) {
			dispose(node.getNext());
		}
		node = null;
	}
	
	
}
