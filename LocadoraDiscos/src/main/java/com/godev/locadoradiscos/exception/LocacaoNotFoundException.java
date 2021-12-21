package com.godev.locadoradiscos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Nenhuma locação foi encontrada")
public class LocacaoNotFoundException extends Exception {

}
