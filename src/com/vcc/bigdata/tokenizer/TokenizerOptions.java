
package com.vcc.bigdata.tokenizer;


public class TokenizerOptions {
	/**
	 * Use a sentence detector before tokenizing text or not.
	 */
	public static boolean USE_SENTENCE_DETECTOR = false;
	
	/**
	 * Use underscores for separating syllbles of words or not.
	 */
	public static boolean USE_UNDERSCORE = true;
	
	/**
	 * Export results as XML format or not.
	 */
	public static boolean XML_OUTPUT = false;
	
	/**
	 * Default file extension for tokenization.
	 */
	public static String TEXT_FILE_EXTENSION = ".txt";
}
