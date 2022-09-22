package com.example.demo.AppConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;

@Getter
@Configuration
@ConfigurationProperties
public class AppConfig {

	@Value("${config.URL}")
	private String URL;

	@Value("${config.KeyAPI}")
	private String keyAPI;

	@Bean
	AppConfigSource AppSource() {
		return new AppConfigSource(URL, keyAPI);
	}

}
