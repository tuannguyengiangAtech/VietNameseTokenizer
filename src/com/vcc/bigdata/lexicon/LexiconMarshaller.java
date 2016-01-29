
package com.vcc.bigdata.lexicon;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.vcc.bigdata.lexicon.jaxb.Body;
import com.vcc.bigdata.lexicon.jaxb.Corpus;
import com.vcc.bigdata.lexicon.jaxb.ObjectFactory;
import com.vcc.bigdata.lexicon.jaxb.W;

/**
 * @author Nguyen Giang Tuan, tuannguyengiang@admicro.vn
 * <p>
 * Unmarshaller of a lexicon.
 */
public class LexiconMarshaller {

	JAXBContext jaxbContext; 
	
	Marshaller marshaller;
	
	/**
	 * Default constructor.
	 */
	public LexiconMarshaller() {
		// create JAXB context
		//
		createContext();
	}
	
	private void createContext() {
		jaxbContext = null;
		try {
			jaxbContext = JAXBContext.newInstance(IConstants.PACKAGE_NAME);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Get the marshaller object.
	 * @return the marshaller object
	 */
	protected Marshaller getMarshaller() {
		if (marshaller == null) {
			try {
				// create the marshaller
				marshaller = jaxbContext.createMarshaller();
				marshaller.setProperty(Marshaller.JAXB_ENCODING, "utf-8");
				marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			} catch (JAXBException e) {
				e.printStackTrace();
			}
		}
		return marshaller;
	}

	/**
	 * Marshal a map of objects to a file.
	 * @param filename the filename of the corpus. This file usually has extension .xml.
	 */
	public void marshal(Map<?, ?> map, String filename) {
		// create the corpus object from the map
		// 
		ObjectFactory factory = new ObjectFactory();
		Corpus corpus = factory.createCorpus();
		corpus.setId(filename);
		
		Body body = factory.createBody();
		corpus.setBody(body);
		
		for (Iterator<?> it = map.keySet().iterator(); it.hasNext(); ) {
			Object key = it.next();
			Object value = map.get(key);
			W w = factory.createW();
			w.setContent(key.toString());
			w.setMsd(value.toString());
			body.getW().add(w);
		}
		// marshal the corpus
		// 
		OutputStream os = null;
		try {
			os = new FileOutputStream(filename);
			getMarshaller().marshal(corpus, os);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
	}
	
}
