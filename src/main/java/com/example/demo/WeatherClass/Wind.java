package com.example.demo.WeatherClass;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.ToString;

@ToString
public class Wind {
	@JsonProperty("speed")
	public double getSpeed() {
		return this.speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	double speed;

	@JsonProperty("deg")
	public int getDeg() {
		return this.deg;
	}

	public void setDeg(int deg) {
		this.deg = deg;
	}

	int deg;
}