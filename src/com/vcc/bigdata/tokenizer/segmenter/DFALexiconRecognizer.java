
package com.vcc.bigdata.tokenizer.segmenter;

import vn.hus.nlp.fsm.IConstants;
import vn.hus.nlp.fsm.fsa.DFA;
import vn.hus.nlp.fsm.fsa.DFASimulator;
import vn.hus.nlp.fsm.io.FSMUnmarshaller;


public final class DFALexiconRecognizer extends AbstractLexiconRecognizer {
	
	private static DFA lexiconDFA = null;
	
	private static DFASimulator simulator = null;
	
	private static DFALexiconRecognizer recognizer = null;
	
	/**
	 * Private constructor.
	 * @param dfaLexiconFilename
	 */
	private DFALexiconRecognizer(String dfaLexiconFilename) {
		if (lexiconDFA == null) {
			// build the lexicon DFA
			System.out.print("Load the lexicon automaton... ");
			lexiconDFA = (DFA) new FSMUnmarshaller().unmarshal(dfaLexiconFilename, IConstants.FSM_DFA);
			System.out.println("OK.");
		}
	}
	
	/**
	 * @param dfaLexiconFilename the DFA lexicon filen
	 * @return The singleton instance of the lexicon DFA. 
	 */
	public static DFALexiconRecognizer getInstance(String dfaLexiconFilename) {
		if (recognizer == null) {
			recognizer = new DFALexiconRecognizer(dfaLexiconFilename);
		}
		return recognizer;
	}

	/**
	 * @return the DFA simulator
	 */
	private DFASimulator getDFASimulator() {
		if (simulator == null) {
			simulator = (DFASimulator)lexiconDFA.getSimulator();
		}
		return simulator;
	}
	
	/* (non-Javadoc)
	 * @see vn.hus.segmenter.AbstractLexiconRecognizer#accept(java.lang.String)
	 */
	@Override
	public boolean accept(String token) {
		return getDFASimulator().accept(token);
	}

	/* (non-Javadoc)
	 * @see vn.hus.segmenter.AbstractLexiconRecognizer#dispose()
	 */
	@Override
	public void dispose() {
		lexiconDFA.dispose();
	}
}
