package com.example.utils.exception;

public class NoDataFoundException extends RuntimeException {
	public NoDataFoundException() {
		super("No data found");
	}
}