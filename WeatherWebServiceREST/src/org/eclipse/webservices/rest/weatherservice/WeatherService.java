package org.eclipse.webservices.rest.weatherservice;

import java.io.IOException;

import org.eclipse.webservices.rest.weatherservice.implementation.WeatherServiceJsonReaderAPI;
import org.json.JSONException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


@Path("/weather/city")
public class WeatherService {

	WeatherServiceJsonReaderAPI weatherServiceObj = new WeatherServiceJsonReaderAPI();


	@GET
	@Produces("application/xml")
	public String defaultSmartFactoryWeather(){

		// Deafult City is Paris!

		String currentTemp = null;
		String cityName = "paris";

		try {

			currentTemp = weatherServiceObj.getCurrentTemperature(cityName) ;

		} catch (JSONException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		String result = "@Produces(\"application/xml\") Output: \n\nCurrent Temperature for City: "+ cityName + " is " + currentTemp + " degree celcius";
		return "<WeatherService>" + "<CityName>" + cityName + "</CityName>" + "<CurrentTemperature>" + result + "</CurrentTemperature>" + "</WeatherService>";

	}


	@Path("{cityName}")
	@GET
	@Produces("application/xml")
	public String getCurrentTemperature(@PathParam("cityName") String cityName) {
		String currentTemp = null;
		try {

			currentTemp = weatherServiceObj.getCurrentTemperature(cityName) ;

		} catch (JSONException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		String result = "@Produces(\"application/xml\") Output: \n\nCurrent Temperature for City: "+ cityName + " is " + currentTemp + " degree celcius";
		return "<WeatherService>" + "<CityName>" + cityName + "</CityName>" + "<CurrentTemperature>" + result + "</CurrentTemperature>" + "</WeatherService>";

	}

	
	public static void main(String[] args) throws IOException, JSONException {

		String cityName = "london";

		WeatherService wsobj = new WeatherService();

		System.out.println(wsobj.getCurrentTemperature(cityName));


	}


}
