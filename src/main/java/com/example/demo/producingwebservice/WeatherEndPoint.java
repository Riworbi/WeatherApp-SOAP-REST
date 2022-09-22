package com.example.demo.producingwebservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.demo.WeatherOperationResponse;
import com.example.demo.WeatherOperation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Endpoint
public class WeatherEndPoint {

	private static final String NAMESPACE = "http://www.example.org/ws/Weather";

	@Autowired
	private final WeatherServiceSOAP weatherServiceSOAP;

	@Autowired
	public WeatherEndPoint(WeatherServiceSOAP weatherServiceSOAP) {
		this.weatherServiceSOAP = weatherServiceSOAP;
	}

	@PayloadRoot(namespace = NAMESPACE, localPart = "WeatherOperation")
	@ResponsePayload
	public WeatherOperationResponse WeatherOperation(@RequestPayload WeatherOperation request) throws JsonMappingException, JsonProcessingException {
		return weatherServiceSOAP.checkWeatherOperation(request);
	}
}
