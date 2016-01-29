/**
 * (C) Nguyen Giang Tuan, tuannguyengiang@admicro.vn
 *  VC Corp , Ha Noi, Viet Nam
 */

package com.vcc.bigdata.graph.util;

/**
 * @author Nguyen Giang Tuan, tuannguyengiang@admicro.vn
 *         <p>
 *         Jan 19, 2016, 9:50:34 PM
 *         <p>
 *         An iterator that examines a list of outcoming edges of a vertex in an
 *         adjacency list graph.
 */
public interface VertexIterator {
	/**
	 * Get the next vertex of the iteration. Note that this method must be
	 * called after checking with {@link #hasNext()}.
	 * 
	 * @return <code>-1</code> or the next vertex index.
	 */
	public int next();

	/**
	 * Returns <tt>true</tt> if the iteration has more vertices.
	 * 
	 * @return <code>true/false</code>
	 */
	public boolean hasNext();
}
