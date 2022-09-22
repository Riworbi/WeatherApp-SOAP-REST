package com.example.demo.WeatherClass;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Setter
@ToString
public class WeatherMainClassSource {

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

	@JsonProperty("coord")
	public Coord getCoord() {
		return this.coord;
	}

	@JsonProperty("weather")
	public ArrayList<Weather> getWeather() {
		return this.weather;
	}

	@JsonProperty("base")
	public String getBase() {
		return this.base;
	}

	@JsonProperty("main")
	public Main getMain() {
		return this.main;
	}

	@JsonProperty("visibility")
	public int getVisibility() {
		return this.visibility;
	}

	@JsonProperty("wind")
	public Wind getWind() {
		return this.wind;
	}

	@JsonProperty("clouds")
	public Clouds getClouds() {
		return this.clouds;
	}

	@JsonProperty("dt")
	public int getDt() {
		return this.dt;
	}

	@JsonProperty("sys")
	public Sys getSys() {
		return this.sys;
	}

	@JsonProperty("timezone")
	public int getTimezone() {
		return this.timezone;
	}

	@JsonProperty("id")
	public int getId() {
		return this.id;
	}

	@JsonProperty("name")
	public String getName() {
		return this.name;
	}

	@JsonProperty("cod")
	public int getCod() {
		return this.cod;
	}

}
