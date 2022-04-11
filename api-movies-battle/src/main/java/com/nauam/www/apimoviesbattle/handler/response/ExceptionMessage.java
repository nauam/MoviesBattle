package com.nauam.www.apimoviesbattle.handler.response;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class ExceptionMessage extends StandardError {

	private List<FieldMessage> errors = new ArrayList<>();

	public ExceptionMessage(Integer status, String msg, Long timeStamp) {
		super(status, msg, timeStamp);
	}

	public void addError(String fieldName, String messagem) {
		errors.add(new FieldMessage(fieldName, messagem));
	}
}