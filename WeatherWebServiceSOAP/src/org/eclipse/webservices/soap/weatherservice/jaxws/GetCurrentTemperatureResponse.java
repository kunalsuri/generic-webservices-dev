
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

@XmlRootElement(name = "getCurrentTemperatureResponse", namespace = "http://weatherservice.soap.webservices.eclipse.org/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCurrentTemperatureResponse", namespace = "http://weatherservice.soap.webservices.eclipse.org/")

public class GetCurrentTemperatureResponse {

    @XmlElement(name = "CurrentTemprature")
    private java.lang.String CurrentTemprature;

    public java.lang.String getCurrentTemprature() {
        return this.CurrentTemprature;
    }

    public void setCurrentTemprature(java.lang.String newCurrentTemprature)  {
        this.CurrentTemprature = newCurrentTemprature;
    }

}

