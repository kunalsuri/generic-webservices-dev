package org.eclipse.webservices.rest.weatherservice.implementation;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeatherServiceJsonReaderAPI {

	public static String WEATHER_SERVICE_URL = "http://api.worldweatheronline.com/premium/v1/weather.ashx?q=";
	public static String WEATHER_API_KEY ="e9821fd760294de6baa83045160405";	
	public static String KEY_EXTRA_PART = "&format=json&key=";

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			is.close();
		}
	}

	public JSONObject getWeatherData(String cityName) throws JSONException, IOException{

		String completeURL = WEATHER_SERVICE_URL + cityName +KEY_EXTRA_PART + WEATHER_API_KEY;
		JSONObject jsonObj = readJsonFromUrl(completeURL);
		return jsonObj;

	}

	public String getTimeofObservation(String cityName) throws JSONException, IOException{

		JSONObject json = getWeatherData(cityName);
		JSONObject weatherDataJobj = json.getJSONObject("data");
		JSONArray current_conditionJsonArray= weatherDataJobj.getJSONArray("current_condition");
		JSONObject current_conditionObj = current_conditionJsonArray.getJSONObject(0);
		String timeOfObservation = current_conditionObj.getString("observation_time").toString();
		//System.out.println(timeOfObservation);
		return timeOfObservation;


	}

	public String getCurrentTemperature(String cityName) throws JSONException, IOException{

		JSONObject json = getWeatherData(cityName);
		JSONObject weatherDataJobj = json.getJSONObject("data");
		JSONArray current_conditionJsonArray= weatherDataJobj.getJSONArray("current_condition");
		JSONObject current_conditionObj = current_conditionJsonArray.getJSONObject(0);
		String currentTemp = current_conditionObj.getString("temp_C").toString();
		//System.out.println(currentTemp);
		return currentTemp;
	}
	
	public String getProbabilityOfRain(String cityName) throws JSONException, IOException{

		String rainProb ;
		
		JSONObject json = getWeatherData(cityName);
		JSONObject CompleteWeatherDataJobj = json.getJSONObject("data");
		JSONArray WeatherDataJAarray = CompleteWeatherDataJobj.getJSONArray("weather");
		JSONObject weatherObj = WeatherDataJAarray.getJSONObject(0);
		//System.out.println(weatherObj.getString("date").toString());

		JSONArray hourlyWeatherJAarray= weatherObj.getJSONArray("hourly");
		JSONObject hourlyWeatherJObj = hourlyWeatherJAarray.getJSONObject(0);
		rainProb = hourlyWeatherJObj.getString("chanceofrain").toString();
		//System.out.println(rainProb);
		
		//JSONObject hourlyWeatherJObj1 = hourlyWeatherJAarray.getJSONObject(1);
		//System.out.println(hourlyWeatherJObj1.getString("chanceofrain").toString());

		return rainProb;
	}

	public static void main(String[] args) throws IOException, JSONException {

		String cityName = "paris";

		WeatherServiceJsonReaderAPI wsobj = new WeatherServiceJsonReaderAPI();

		wsobj.getTimeofObservation(cityName);
		wsobj.getCurrentTemperature(cityName);
		wsobj.getProbabilityOfRain(cityName); 

	}

}

// Note: http://stackoverflow.com/questions/14933173/how-to-parse-nested-json-arrays-in-a-single-object-in-android