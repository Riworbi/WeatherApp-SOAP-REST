package com.example.demo.SoapWebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.WeatherOperation;
import com.example.demo.WeatherOperationResponse;
import com.example.demo.City.City;
import com.example.demo.Service.WeatherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public class WeatherServiceSOAP {

	@Autowired
	private WeatherService service;

	public WeatherOperationResponse checkWeatherOperation(WeatherOperation request)
			throws JsonMappingException, JsonProcessingException {

		for (City miasto : service.findAll()) {
			if ((miasto.getName().equals(request.getMiasto())) && (miasto.getId() == request.getCorrelationID())) {
				double temp = service.getWeatherObjectOfCertainCity(request.getMiasto()).getMain().getTemp();

				WeatherOperationResponse weatherOperationResponse = new WeatherOperationResponse();
				weatherOperationResponse.setCorrelationID(request.getCorrelationID());
				weatherOperationResponse.setTemperatura(String.valueOf(service.KelvinToCelcius(temp)));
				return weatherOperationResponse;

			}
		}
		return null;
	}

}
