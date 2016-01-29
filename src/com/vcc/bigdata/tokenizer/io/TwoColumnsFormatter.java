/**
 * @author Nguyen Giang Tuan
 * 8 sept. 2015
 */
package com.vcc.bigdata.tokenizer.io;

import com.vcc.bigdata.tokenizer.tokens.TaggedWord;


public class TwoColumnsFormatter implements IOutputFormatter {

	
	public String outputLexeme(TaggedWord token) {
		StringBuffer stBuf = new StringBuffer();
		// output the text
		stBuf.append(token.getText());
		// a tab character
		stBuf.append("\t");
		// its type
		stBuf.append(token.getRule().getName());
		// end of line
		stBuf.append("\n");
		return stBuf.toString();
	}

}
