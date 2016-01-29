
package com.vcc.bigdata.tokenizer.io;

import com.vcc.bigdata.tokenizer.tokens.TaggedWord;


public interface IOutputListener {
	/**
	 * Notifies a token to be outputed.
	 * @param token a lexer token.
	 */
	public void outputToken(TaggedWord token);
}
