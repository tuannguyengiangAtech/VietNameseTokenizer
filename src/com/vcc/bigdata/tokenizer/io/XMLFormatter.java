package com.vcc.bigdata.tokenizer.io;

import com.vcc.bigdata.tokenizer.tokens.TaggedWord;



public class XMLFormatter implements IOutputFormatter {

	
	public String outputLexeme(TaggedWord lexeme) {
		StringBuffer stBuf = new StringBuffer();
		stBuf.append("<w>");
		stBuf.append(lexeme.getText());
		stBuf.append("</w>\n");
		return stBuf.toString();

	}

}
