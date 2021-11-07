package com.musala.unitdemo.exception;

import lombok.Getter;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 3873418545077760440L;

	@Getter
	private final Integer userId;

	public UserNotFoundException(String message, Integer userId) {
		super(message);
		this.userId = userId;
	}
}
