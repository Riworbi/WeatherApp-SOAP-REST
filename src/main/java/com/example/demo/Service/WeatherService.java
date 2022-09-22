package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.AppConfig.AppConfig;
import com.example.demo.City.City;
import com.example.demo.City.CityRepository;
import com.example.demo.WeatherClass.WeatherMainClass;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Setter;
import net.minidev.json.JSONObject;

@Service
@Setter
public class WeatherService {

	@Autowired
	private ObjectMapper mapper;
	@Autowired
	private AppConfig appConfig;
	@Autowired
	private CityRepository cityRepository;

	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}

	@Bean
	public WeatherMainClass Weather() {
		return new WeatherMainClass();
	}

	public List<City> findAll() {
		return cityRepository.findAll();
	}

	private City CheckIfCityIsAvailible(List<City> cities, String city) {
		for (City City : cities) {
			if (City.getName().equals(city)) {
				return City;
			}
		}
		return null;
	}

	public WeatherMainClass getWeatherObjectOfCertainCity(String city)
			throws JsonMappingException, JsonProcessingException {
		String JSON = getJSONofCity(city);
		return mapper.readValue(JSON, WeatherMainClass.class);
	}

	public String getJSONofCity(String City) {
		List<City> cities = cityRepository.findAll();
		City city = CheckIfCityIsAvailible(cities, City);
		String URL = appConfig.getURL() + "lat=" + city.getLon() + "&lon=" + city.getLat() + "&appid="
				+ appConfig.getKeyAPI();
		return template().getForObject(URL, String.class);
	}

	public JSONObject getJsonObjectOfWeather(WeatherMainClass weather) {
		JSONObject ObjectJSON = new JSONObject();
		ObjectJSON.put("name", weather.getName());
		ObjectJSON.put("feels_like", KelvinToCelcius(weather.getMain().getTemp()));
		ObjectJSON.put("icon",
				"https://openweathermap.org/img/wn/" + weather.getWeather().get(0).getIcon() + "@2x.png");

		return ObjectJSON;
	}

	public String showResultsWeather(WeatherMainClass weather) {
		return "Miasto:" + weather.getName() + " Odczuwalna:" + KelvinToCelcius(weather.getMain().getFeels_like());
	}

	public String KelvinToCelcius(double Kelvin) {
		String result = String.format("%.0f", Kelvin - 273.15);
		return result;
	}

}
