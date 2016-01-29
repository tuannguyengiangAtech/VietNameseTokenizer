
package com.vcc.bigdata.graph.util;

import com.vcc.bigdata.graph.AdjacencyMatrixGraph;
import com.vcc.bigdata.graph.Edge;
import com.vcc.bigdata.graph.IGraph;


public class GraphTransitiveClosure {

	/**
	 * Get the transitive closure of a graph.
	 * 
	 * @param g a graph.
	 * @return the transitive closure of <code>g</code>. 
	 */
	public static IGraph getTransitiveClosure(IGraph g) {
		// copy the original graph
		IGraph transitiveClosure = GraphUtilities.copy(g, true);
		int n = g.getNumberOfVertices();
		// add dummy loop edges
		for (int u = 0; u < n; u++) {
			transitiveClosure.insert(new Edge(u, u));
		}
		// the Warhall's algorithm to compute the transitive closure
		for (int v = 0; v < n; v++)
			for (int u = 0; u < n; u++)
				if (transitiveClosure.edge(u, v)) {
					for (int w = 0; w < n; w++)
						if (transitiveClosure.edge(v, w))
							transitiveClosure.insert(new Edge(u, w));
				}
		return transitiveClosure;
	}

}
