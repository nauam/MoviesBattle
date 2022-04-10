package com.nauam.www.apimoviesbattle.message.response;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class ExceptionMessage extends StandardError {
	private static final long serialVersionUID = 1L;

	private List<FieldMessage> errors = new ArrayList<>();

	public ExceptionMessage(Integer status, String msg, Long timeStamp) {
		super(status, msg, timeStamp);
	}

	public void addError(String fieldName, String messagem) {
		errors.add(new FieldMessage(fieldName, messagem));
	}

}