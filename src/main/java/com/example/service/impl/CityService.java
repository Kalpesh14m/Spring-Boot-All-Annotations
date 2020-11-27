package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.CityDTO;
import com.example.model.City;
import com.example.repo.CityRepository;
import com.example.service.ICityService;
import com.example.utils.exception.CityAlreadyRegistredException;
import com.example.utils.exception.CityNotFoundException;
import com.example.utils.exception.NoDataFoundException;

@Service
public class CityService implements ICityService {

	@Autowired
	private CityRepository cityRepository;

	@Override
	public void addCity(CityDTO city) {
		if (cityRepository.findByName(city.getName()).isPresent())
			throw new CityAlreadyRegistredException(city.getName());
		cityRepository.save(new City(city.getName(), city.getPopulation()));
	}

	@Override
	public City findById(Long id) {
		return cityRepository.findById(id).orElseThrow(() -> new CityNotFoundException(id));
	}

	@Override
	public List<City> getAllCities() {
		List<City> cities = (List<City>) cityRepository.findAll();
		if (cities.isEmpty()) {
			throw new NoDataFoundException();
		}
		return cities;
	}

	@Override
	public void deleteCity(Long id) {
		cityRepository.deleteById(findById(id).getId());
	}
}