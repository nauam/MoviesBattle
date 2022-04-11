package com.nauam.www.apimoviesbattle.login.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.nauam.www.apimoviesbattle.handler.response.FieldMessage;
import com.nauam.www.apimoviesbattle.login.request.SigninRequest;
import com.nauam.www.apimoviesbattle.login.validation.SigninValidation;
import com.nauam.www.apimoviesbattle.user.model.User;
import com.nauam.www.apimoviesbattle.user.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class SigninService implements ConstraintValidator<SigninValidation, SigninRequest> {

	@Autowired
	private UserRepository repository;

	@Override
	public void initialize(SigninValidation constraintAnnotation) {
	}

	@Override
	public boolean isValid(SigninRequest obj, ConstraintValidatorContext context) {

		List<FieldMessage> list = new ArrayList<>();

		Optional<User> tmpUsername = repository.findByUsername(obj.getUsername());
		if (tmpUsername.isEmpty()) {
			list.add(new FieldMessage("username", "Username não existente"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage())
				   .addPropertyNode(e.getFieldName())
				   .addConstraintViolation();
		}
		return list.isEmpty();
	}
}
