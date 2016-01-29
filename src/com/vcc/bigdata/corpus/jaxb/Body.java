package com.vcc.bigdata.corpus.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "pOrS"
})
@XmlRootElement(name = "body")
public class Body {

    @XmlElements({
        @XmlElement(name = "p", type = P.class),
        @XmlElement(name = "s", type = S.class)
    })
    protected List<Object> pOrS;


    public List<Object> getPOrS() {
        if (pOrS == null) {
            pOrS = new ArrayList<Object>();
        }
        return this.pOrS;
    }

}
