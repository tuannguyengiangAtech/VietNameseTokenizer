
package com.vcc.bigdata.tokenizer.segmenter;

import java.util.List;


public abstract class AbstractResolver {
	/**
	 * @param segmentations a list of segmentations for a phrase.
	 * @return the most probable segmentation
	 */
	public abstract String[] resolve(List<String[]> segmentations);
}
