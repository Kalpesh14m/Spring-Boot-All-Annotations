package com.example.service;

import java.util.List;

import com.example.dto.CityDTO;
import com.example.model.City;

public interface ICityService {
	public void addCity(CityDTO city);

	public City findById(Long id);

	public List<City> getAllCities();

	public void deleteCity(Long id);

}
