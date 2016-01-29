/**
 * 
 */
package com.vcc.bigdata.tokenizer.segmenter;


public abstract class AbstractLexiconRecognizer {
	/**
	 * @param token
	 * @return <tt>true</tt> if the token is accepted, <tt>false</tt> otherwise. 
	 */
	public abstract boolean accept(String token);
	
	/**
	 * Dispose the recognizer for saving space.
	 */
	public abstract void dispose();
}
