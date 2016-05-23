/*
 * Author:  KUNAL SURI
 */

package org.eclipse.webservices.soap.weatherservice;

import java.io.IOException;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import org.eclipse.webservices.soap.weatherservice.implementation.WeatherServiceJsonReaderAPI;
import org.json.JSONException;

/*
 * The "web" annotations are automatically generated while creating the WebService with Apache CXF
 * 
 */
@WebService(targetNamespace = "http://weatherservice.soap.webservices.eclipse.org/", portName = "WeatherServicePort", serviceName = "WeatherServiceService")
public class WeatherService {

	WeatherService(){

	}

	WeatherServiceJsonReaderAPI weatherServiceObj = new WeatherServiceJsonReaderAPI();


	@WebMethod(operationName = "getTimeofWeatherObservation", action = "urn:GetTimeofWeatherObservation")
	@RequestWrapper(className = "org.eclipse.webservices.soap.weatherservice.jaxws.GetTimeofWeatherObservation", localName = "getTimeofWeatherObservation", targetNamespace = "http://weatherservice.soap.webservices.eclipse.org/")
	@ResponseWrapper(className = "org.eclipse.webservices.soap.weatherservice.jaxws.GetTimeofWeatherObservationResponse", localName = "getTimeofWeatherObservationResponse", targetNamespace = "http://weatherservice.soap.webservices.eclipse.org/")
	@WebResult(name = "TimeOfWeatherObservation")
	public String getTimeofWeatherObservation(@WebParam(name = "CityName") String cityName) {

		String timeOfWeatherObservation = null;
		try {
			timeOfWeatherObservation = weatherServiceObj.getTimeofObservation(cityName) ;
		} catch (JSONException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return timeOfWeatherObservation;
	}

	@WebMethod(operationName = "getCurrentTemperature", action = "urn:GetCurrentTemperature")
	@RequestWrapper(className = "org.eclipse.webservices.soap.weatherservice.jaxws.GetCurrentTemperature", localName = "getCurrentTemperature", targetNamespace = "http://weatherservice.soap.webservices.eclipse.org/")
	@ResponseWrapper(className = "org.eclipse.webservices.soap.weatherservice.jaxws.GetCurrentTemperatureResponse", localName = "getCurrentTemperatureResponse", targetNamespace = "http://weatherservice.soap.webservices.eclipse.org/")
	@WebResult(name = "CurrentTemprature")
	public String getCurrentTemperature(@WebParam(name = "CityName") String cityName) {

		String currentTemp = null;
		try {
			currentTemp = weatherServiceObj.getCurrentTemperature(cityName) ;
		} catch (JSONException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currentTemp;
	}


	@WebMethod(operationName = "getProbabilityOfRain", action = "urn:GetProbabilityOfRain")
	@RequestWrapper(className = "org.eclipse.webservices.soap.weatherservice.jaxws.GetProbabilityOfRain", localName = "getProbabilityOfRain", targetNamespace = "http://weatherservice.soap.webservices.eclipse.org/")
	@ResponseWrapper(className = "org.eclipse.webservices.soap.weatherservice.jaxws.GetProbabilityOfRainResponse", localName = "getProbabilityOfRainResponse", targetNamespace = "http://weatherservice.soap.webservices.eclipse.org/")
	@WebResult(name = "ProbabilityOfRain")
	public String getProbabilityOfRain(@WebParam(name = "CityName") String cityName){

		String rainProb = null;
		try {
			rainProb = weatherServiceObj.getProbabilityOfRain(cityName) ;
		} catch (JSONException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rainProb;
	}


	public static void main(String[] args) throws IOException, JSONException {

		String cityName = "london";
		WeatherService wsobj = new WeatherService();
		System.out.println(wsobj.getCurrentTemperature(cityName));
		System.out.println(wsobj.getProbabilityOfRain(cityName));
	}


}
