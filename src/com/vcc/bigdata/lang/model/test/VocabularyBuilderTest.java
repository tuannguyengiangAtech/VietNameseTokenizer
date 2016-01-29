
package com.vcc.bigdata.lang.model.test;

import java.io.IOException;

import com.vcc.bigdata.lang.model.unigram.Unigram;
import com.vcc.bigdata.lang.model.unigram.VocabularyBuilder;


public final class VocabularyBuilderTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// create an empty unigram model
		Unigram unigram = Unigram.getInstance();
		// load the sample corpus to the unigram.
		try {
			Unigram.loadCorpus(TestConstants.CORPUS_NAME);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// create the vocabulary of the model with the default cuttoff (1)
		VocabularyBuilder vocabularyBuilder = new VocabularyBuilder(unigram);
		// print the vocabulary
		vocabularyBuilder.print(TestConstants.VOCABULARY_1_TXT);
		
		// create another vocabulary of the model with a cutoff
		vocabularyBuilder = new VocabularyBuilder(unigram, 5);
		// print the vocabulary
		vocabularyBuilder.print(TestConstants.VOCABULARY_5_TXT);
	}

}
