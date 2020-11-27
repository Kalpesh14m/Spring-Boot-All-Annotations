package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.CityDTO;
import com.example.model.City;
import com.example.service.CityName;
import com.example.service.ICityService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController("/cities")
public class CityController {
	@Autowired
	private ICityService cityService;

	@Autowired
	private CityName cityName;

	@RequestMapping(path = "/test", method = RequestMethod.GET, produces = "text/plain")
	public String msg() {
		return "City Controller" + " \nCity Name: " + cityName.getName();
	}

	@PostMapping(value = "/")
	public String addCity(@RequestBody CityDTO city) {
		cityService.addCity(city);
		return city.getName() + " Added";
	}

	@GetMapping("/")
	public List<City> getCities() {
		return cityService.getAllCities();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<City> getCityById(@PathVariable(name = "id") final Long cityId) {
		return new ResponseEntity<>(cityService.findById(cityId), HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteCity(@PathVariable(name = "id") final Long cityId) {
		cityService.deleteCity(cityId);
		return "City Celeted..!!";
	}

}
