
package com.vcc.bigdata.tokenizer.io;

import com.vcc.bigdata.tokenizer.tokens.TaggedWord;



public interface IOutputFormatter {
	/**
	 * Output a token
	 * @param token
	 * @return a string representing the output of the token.
	 */
	public String outputLexeme(TaggedWord token);
}
