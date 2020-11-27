package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.example.service.CityName;
import com.example.service.UserName;

@SpringBootApplication
public class LearningAnnotationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningAnnotationsApplication.class, args);
	}

	@Bean("userBean")
	@Scope("prototype")
	@DependsOn("cityBean")
	public UserName getUserName(@Value("${user.controller}") String userName) {
		System.out.println(userName);
		return () -> userName;
	}

	@Bean("cityBean")
	@Lazy(value = true)
	public CityName getCityName(@Value("${city.controller}") String cityName) {
		System.out.println(cityName);
		return () -> cityName;
	}
}
