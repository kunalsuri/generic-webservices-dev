
package org.eclipse.webservices.soap.weatherservice.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 3.1.5
 * Mon May 23 17:30:32 CEST 2016
 * Generated source version: 3.1.5
 */

@XmlRootElement(name = "getProbabilityOfRainResponse", namespace = "http://weatherservice.soap.webservices.eclipse.org/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getProbabilityOfRainResponse", namespace = "http://weatherservice.soap.webservices.eclipse.org/")

public class GetProbabilityOfRainResponse {

    @XmlElement(name = "ProbabilityOfRain")
    private java.lang.String ProbabilityOfRain;

    public java.lang.String getProbabilityOfRain() {
        return this.ProbabilityOfRain;
    }

    public void setProbabilityOfRain(java.lang.String newProbabilityOfRain)  {
        this.ProbabilityOfRain = newProbabilityOfRain;
    }

}

