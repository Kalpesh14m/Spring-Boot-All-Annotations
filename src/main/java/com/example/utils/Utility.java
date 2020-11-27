package com.example.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.example.service.DeptName;

@Component
public class Utility {
	public int addNumbers(int num1, int num2) {
		return num1 + num2;
	}

	@Bean("deptBean")
	public DeptName getDeptName(@Value("${dept.controller}") String deptName) {
		System.out.println(deptName);
		return () -> deptName;
	}

	@Bean
	public Square getSquare() {
		return new Square();
	}
}
