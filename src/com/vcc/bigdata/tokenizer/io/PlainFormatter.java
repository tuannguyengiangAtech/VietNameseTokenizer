/**
 * @author LE Hong Phuong
 * 8 sept. 2005
 */
package com.vcc.bigdata.tokenizer.io;

import com.vcc.bigdata.tokenizer.tokens.TaggedWord;


public class PlainFormatter implements IOutputFormatter {

	
	public String outputLexeme(TaggedWord token) {
		StringBuffer stBuf = new StringBuffer();
		// output only the text of the token
		stBuf.append(token.getText());
		// end of line
		stBuf.append("\n");
		return stBuf.toString();
	}

}
