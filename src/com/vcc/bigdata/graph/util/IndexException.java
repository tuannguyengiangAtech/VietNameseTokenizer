
package com.vcc.bigdata.graph.util;



public class IndexException extends Exception {
	
	public IndexException() {
		super();
	}
	 @Override
	public void printStackTrace() {
		super.printStackTrace();
		System.err.println("The vertex index is not valid!");
	}
}
