package com.example.demo.WeatherClass;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.ToString;

@ToString
public class Clouds {
	@JsonProperty("all")
	public int getAll() {
		return this.all;
	}

	public void setAll(int all) {
		this.all = all;
	}

	int all;
}