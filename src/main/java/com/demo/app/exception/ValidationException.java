package com.demo.app.exception;

import java.util.Collections;
import java.util.List;

public class ValidationException extends RuntimeException{
	
	public ValidationException(String message) {
		super(message);
	}

	public List getErrors() {
		return Collections.unmodifiableList(null);
	}

}
