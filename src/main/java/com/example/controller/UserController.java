package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.UserName;

@RestController
public class UserController {

	@Autowired
	private UserName userName;

	@GetMapping("/user")
	public String msg() {
		return "In User Controller" + " \nUser Name: " + userName.getUserName();
	}
}