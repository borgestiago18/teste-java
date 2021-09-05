package br.com.confidencecambio.javabasico.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.confidencecambio.javabasico.exception.AlturaException;

@RestControllerAdvice
public class ErrorController {
	
	@ExceptionHandler(value = {AlturaException.class})
	public ResponseEntity<?> onAlturaException(AlturaException alturaException) {
		
		Map<String, String> body = new LinkedHashMap<>();
		body.put("erro", "A altura deve ser maior que 0");
		
		return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}
}
