
package com.vcc.bigdata.tokenizer.segmenter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import vn.hus.nlp.utils.UTF8FileUtility;


public final class StringNormalizer {
	
	private static Map<String, String> map;
	
	private StringNormalizer(String mapFile) {
		map = new HashMap<String, String>();
		init(mapFile);
	}
	
	
	private void init(String mapFile) {
		String[] rules = UTF8FileUtility.getLines(mapFile);
		for (int i = 0; i < rules.length; i++) {
			String[] s = rules[i].split("\\s+");
			if (s.length == 2) {
				map.put(s[0], s[1]);
			} else {
				System.err.println("Wrong syntax in the map file " + mapFile + " at line " + i);
			}
		}
	}


	/**
	 * @return an instance of the class.
	 */
	public static StringNormalizer getInstance() {
		return new StringNormalizer(IConstants.NORMALIZATION_RULES);
	}

	/**
	 * Normalize a string.
	 * @return a normalized string
	 * @param s a string
	 */
	public String normalize(String s) {
		String result = new String(s);
		for (Iterator<String> it = map.keySet().iterator(); it.hasNext();) {
			String from = it.next();
			String to = map.get(from);
			if (result.indexOf(from) >= 0) {
				result = result.replace(from, to);
			}
		}
		return result;
	}
	
}
