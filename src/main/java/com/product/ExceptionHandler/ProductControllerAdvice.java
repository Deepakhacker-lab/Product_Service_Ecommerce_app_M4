package com.product.ExceptionHandler;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.product.Entity.StringResponse;

@ControllerAdvice
public class ProductControllerAdvice {

	
	
	@ExceptionHandler(value= ProductAlreadyExistInCartException.class)
	public  ResponseEntity<StringResponse> handleException(ProductAlreadyExistInCartException exec){
		StringResponse add = new StringResponse("Product already Exist");

		return new ResponseEntity<>(add, HttpStatus.ALREADY_REPORTED);		
		
	}
	@ExceptionHandler(value = ProductException.class)
	public ResponseEntity<StringResponse> handleProductException(ProductException exec){
		
		StringResponse add = new StringResponse("Product already Exist");
		
		return new ResponseEntity<>(add, HttpStatus.ALREADY_REPORTED);		
		
	}
	@ExceptionHandler
	public ResponseEntity<StringResponse> handleGlobalException(Exception exec){
		
		StringResponse add = new StringResponse(exec.getMessage());
		
		return new ResponseEntity<>(add, HttpStatus.BAD_REQUEST);		
		
	}
	
}
