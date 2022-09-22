package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.WeatherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import net.minidev.json.JSONArray;

@RestController
public class Controller {

	@Autowired
	private WeatherService service;

	@CrossOrigin
	@RequestMapping(value = "/cities", method = RequestMethod.GET)
	public JSONArray getWeather(@RequestParam List<String> miasta)
			throws JsonMappingException, JsonProcessingException {

		JSONArray JSON = new JSONArray();
		for (String miasto : miasta) {
			JSON.add(service.getJsonObjectOfWeather(service.getWeatherObjectOfCertainCity(miasto)));
		}
		return JSON;
	}
}
