
package org.eclipse.webservices.soap.weatherservice;

import javax.xml.ws.Endpoint;

/**
 * This class was generated by Apache CXF 3.1.5
 * 2016-05-23T17:30:33.056+02:00
 * Generated source version: 3.1.5
 * 
 */
 
public class WeatherService_PortTypeServer{

    protected WeatherService_PortTypeServer() throws Exception {
        System.out.println("Starting Server");
        Object implementor = new org.eclipse.webservices.soap.weatherservice.WeatherService();
        String address = "http://localhost:9090/WeatherServicePort";
        Endpoint.publish(address, implementor);
    }
    
    public static void main(String args[]) throws Exception { 
        new WeatherService_PortTypeServer();
        System.out.println("Server ready..."); 
        
        Thread.sleep(5 * 60 * 1000); 
        System.out.println("Server exiting");
        System.exit(0);
    }
}
 
 