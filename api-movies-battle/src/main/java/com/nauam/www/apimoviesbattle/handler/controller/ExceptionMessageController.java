package com.nauam.www.apimoviesbattle.handler.controller;

import javax.servlet.http.HttpServletRequest;

import com.nauam.www.apimoviesbattle.handler.response.ExceptionMessage;
import com.nauam.www.apimoviesbattle.handler.response.StandardError;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionMessageController {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {
		ExceptionMessage err = new ExceptionMessage(HttpStatus.BAD_REQUEST.value(), "Erro de validação", System.currentTimeMillis());
		for (FieldError x : e.getBindingResult().getFieldErrors()) {
			err.addError(x.getField(), x.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}

}