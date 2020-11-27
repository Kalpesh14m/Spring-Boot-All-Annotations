package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.utils.Utility;

@RestController
public class DeptController {
	@Value(value = "${dept.controller}")
	private String myDept;

	@Autowired
	private Utility util;

	@GetMapping("/dept")
	public String msg() {
		util.addNumbers(10, 20);
		return "In Department Controller " + " \nDept Bean: " + util.getDeptName(myDept).getDeptName()
				+ " \nsquare of 5: " + util.getSquare().getSquare(5);
	}
}
