package com.example.utils.exception;

public class CityAlreadyRegistredException extends RuntimeException {
	public CityAlreadyRegistredException(String cityName) {
		super(String.format("City with Id %s already found", cityName));
	}
}