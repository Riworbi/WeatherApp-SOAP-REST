package com.example.demo.WeatherClass;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class WeatherMainClass {

	Coord coord;
	ArrayList<Weather> weather;
	String base;
	Main main;
	int visibility;
	Wind wind;
	Clouds clouds;
	int dt;
	Sys sys;
	int timezone;
	int id;
	String name;
	int cod;

	
	@Bean
	WeatherMainClassSource WeatherMain() {
		return new WeatherMainClassSource(coord, weather, base, main, visibility, wind, clouds, dt, sys, timezone, id,
				name, cod);
	}

}
