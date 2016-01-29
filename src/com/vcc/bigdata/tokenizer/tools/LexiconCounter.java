
package com.vcc.bigdata.tokenizer.tools;

import java.util.Formatter;
import java.util.Locale;

import vn.hus.nlp.utils.UTF8FileUtility;


public final class LexiconCounter {
	/**
	 * A lexicon filename
	 */
	String lexiconFile;

	public LexiconCounter(String lexiconFile) {
		this.lexiconFile = lexiconFile;
	}

	public void count() {
		// get all lines of the lexicon
		String[] lines = UTF8FileUtility.getLines(lexiconFile);
		// count
		int[] counters = { 0, 0, 0, 0, 0};
		for (int i = 0; i < lines.length; i++) {
			String[] syllables = lines[i].split("\\s+");
			int len = syllables.length;
			if (0 < len) {
				if (len <= 4) {
					counters[syllables.length - 1]++;
				} else {
					counters[counters.length - 1]++;
				}
			}
		}
		System.out.println("# of lexicon = " + lines.length);
		for (int i = 0; i < counters.length; i++) {
			Formatter formatter = new Formatter(System.out);
			formatter.format(Locale.US, "%s %d = %d, %4.2f\n",
					"# of length ", i+1, counters[i], (float) counters[i]
							/ lines.length * 100);
		}
		// verify the total number
		int m = 0;
		for (int i = 0; i < counters.length; i++) {
			m += counters[i];
		}
		System.out.println("Total = " + m);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new LexiconCounter("dictionaries/words_v3_set.txt").count();
	}

}
