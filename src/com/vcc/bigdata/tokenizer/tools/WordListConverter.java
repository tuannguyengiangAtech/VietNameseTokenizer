/**
 * 
 */
package com.vcc.bigdata.tokenizer.tools;

import java.util.Map;
import java.util.TreeMap;

import com.vcc.bigdata.lexicon.LexiconMarshaller;
import vn.hus.nlp.utils.UTF8FileUtility;


public class WordListConverter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String fileInp = "data/dictionaries/words_v4.txt";
		String fileOut = "data/dictionaries/words_v4.xml";
		
		String[] words = UTF8FileUtility.getLines(fileInp);
		Map<String, String> wordMap = new TreeMap<String, String>();
		for (String word : words) {
			word = word.trim();
			if (word.length() > 0)
				wordMap.put(word, "");
		}
		LexiconMarshaller marshaller = new LexiconMarshaller();
		marshaller.marshal(wordMap, fileOut);
		System.out.println("Done");
	}

}
