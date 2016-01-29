package com.vcc.bigdata.tokenizer.nio;

import java.util.List;

import com.vcc.bigdata.tokenizer.tokens.TaggedWord;


public interface IExporter {
	/**
	 * Creates a string representation of an array of lists of tokens.
	 * @param list
	 * @return a string
	 */
	public String export(List<List<TaggedWord>> list);
}
