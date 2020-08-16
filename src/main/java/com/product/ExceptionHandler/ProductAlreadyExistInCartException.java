package com.product.ExceptionHandler;

public class ProductAlreadyExistInCartException extends RuntimeException{

	public ProductAlreadyExistInCartException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProductAlreadyExistInCartException(String message) {
		super(message);
	}

	public ProductAlreadyExistInCartException(Throwable cause) {
		super(cause);
	}


	
}
