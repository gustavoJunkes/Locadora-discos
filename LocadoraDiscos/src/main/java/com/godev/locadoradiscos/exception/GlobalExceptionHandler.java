package com.godev.locadoradiscos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({ DiscoNotFoundException.class, ClienteNotFoundException.class, LocacaoNotFoundException.class })
	public ResponseEntity<String> exceptionHandler(Exception ex, WebRequest request) {
		return new ResponseEntity<>("Um erro ocorreu durante a execução do sistema:  " + ex.getMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
