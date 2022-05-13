package com.cg.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
	public class GlobalExceptionHandler {
		
		@Value(value="${data.exception.msg}")
		private String msg;
		
		@ExceptionHandler(value = OrderAlreadyExists.class)
		public ResponseEntity<String> GameAlreadyExistsException(OrderAlreadyExists dap){
		        return new ResponseEntity<String>(msg, HttpStatus.CONFLICT);
		}
			
		@Value(value="${data.exception.msg1}")
		private String msg1;
		
		@ExceptionHandler(value = OrderIdNotFound.class)
		public ResponseEntity<String> GameIdNotFound(OrderIdNotFound dap){
		        return new ResponseEntity<String>(msg1, HttpStatus.CONFLICT);

	}
}

