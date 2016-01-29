/**
 * 
 */
package com.vcc.bigdata.tokenizer.tools;

import java.util.Set;
import java.util.TreeSet;

import vn.hus.nlp.utils.UTF8FileUtility;


public class WordListMerger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String file1 = "data/dictionaries/words_v3.txt";
		String file2 = "data/dictionaries/extractedWords.txt";
		
		
		Set<String> words = new TreeSet<String>();
		String[] a1 = UTF8FileUtility.getLines(file1);
		String[] a2 = UTF8FileUtility.getLines(file2);
		
		for (String word : a1) {
			words.add(word);
		}
		
		for (String word : a2) {
			words.add(word);
		}
		
		String fileOut = "data/dictionaries/words_v4.txt";
		
		UTF8FileUtility.createWriter(fileOut);
		UTF8FileUtility.write(words.toArray(new String[words.size()]));
		UTF8FileUtility.closeWriter();
	}

}
