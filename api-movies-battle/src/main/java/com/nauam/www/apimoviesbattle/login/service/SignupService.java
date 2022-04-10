package com.nauam.www.apimoviesbattle.login.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.nauam.www.apimoviesbattle.login.request.SignupRequest;
import com.nauam.www.apimoviesbattle.login.validation.SignupValidation;
import com.nauam.www.apimoviesbattle.message.response.FieldMessage;
import com.nauam.www.apimoviesbattle.user.model.User;
import com.nauam.www.apimoviesbattle.user.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class SignupService implements ConstraintValidator<SignupValidation, SignupRequest> {

	@Autowired
	private UserRepository repository;

	@Override
	public void initialize(SignupValidation constraintAnnotation) {
	}

	@Override
	public boolean isValid(SignupRequest userDto, ConstraintValidatorContext context) {

		List<FieldMessage> list = new ArrayList<>();

		Optional<User> tmpUsername = repository.findByUsername(userDto.getUsername());
		if (!tmpUsername.isEmpty()) {
			list.add(new FieldMessage("username", "Username já existente"));
		}

		Optional<User> tmpEmail = repository.findByEmail(userDto.getEmail());
		if (!tmpEmail.isEmpty()) {
			list.add(new FieldMessage("email", "Email já existente"));
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
