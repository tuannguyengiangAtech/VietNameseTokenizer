
package com.vcc.bigdata.lang.model.test;

import java.io.IOException;

import com.vcc.bigdata.lang.model.unigram.Unigram;


public final class UnigramTest {

	public static void main(String[] args) {
		// load the sample corpus to a unigram model and print the model to a
		// plain text file
		// and an XML file.
		Unigram.getInstance();
		try {
			Unigram.loadCorpus(TestConstants.CORPUS_NAME);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Unigram.print(TestConstants.UNIGRAM_TEXT);
		Unigram.marshal(TestConstants.UNIGRAM_XML);
	}
}
