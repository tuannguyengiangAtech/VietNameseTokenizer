
package com.vcc.bigdata.tokenizer.segmenter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.vcc.bigdata.lexicon.LexiconUnmarshaller;
import com.vcc.bigdata.lexicon.jaxb.Corpus;
import com.vcc.bigdata.lexicon.jaxb.W;


public class ExternalLexiconRecognizer extends AbstractLexiconRecognizer {

	
	private Set<String> externalLexicon;
	
	
	/**
	 * Default constructor. 
	 */
	public ExternalLexiconRecognizer() {
		this(IConstants.EXTERNAL_LEXICON);
	}
	
	/**
	 * Creates an external lexicon recognizer given a lexicon.
	 * @param externalLexiconFilename a lexicon filename
	 */
	public ExternalLexiconRecognizer(String externalLexiconFilename) {
		// load the prefix lexicon
		// 
		LexiconUnmarshaller  lexiconUnmarshaller = new LexiconUnmarshaller();
		Corpus lexicon = lexiconUnmarshaller.unmarshal(externalLexiconFilename);
		List<W> ws = lexicon.getBody().getW();
		externalLexicon = new HashSet<String>();
		// add all prefixes to the set after converting them to lowercase
		for (W w : ws) {
			externalLexicon.add(w.getContent().toLowerCase());
		}
		System.out.println("External lexicon loaded.");
	}

	/* (non-Javadoc)
	 * @see com.vcc.bigdata.tokenizer.segmenter.AbstractLexiconRecognizer#accept(java.lang.String)
	 */
	@Override
	public boolean accept(String token) {
		return externalLexicon.contains(token);
	}

	/* (non-Javadoc)
	 * @see com.vcc.bigdata.tokenizer.segmenter.AbstractLexiconRecognizer#dispose()
	 */
	@Override
	public void dispose() {
		externalLexicon.clear();
		externalLexicon = null;
	}

	/**
	 * Gets the external lexicon.
	 * @return the external lexicon.
	 */
	public Set<String> getExternalLexicon() {
		return externalLexicon;
	}
}
