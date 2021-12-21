package com.godev.locadoradiscos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Nenhum cliente foi encontrado")
public class ClienteNotFoundException extends RuntimeException {
	public ClienteNotFoundException() {
	}
}
