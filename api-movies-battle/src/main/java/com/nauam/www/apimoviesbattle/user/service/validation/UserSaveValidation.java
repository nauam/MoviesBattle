package com.nauam.www.apimoviesbattle.user.service.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.nauam.www.apimoviesbattle.user.controller.exception.FieldMessage;
import com.nauam.www.apimoviesbattle.user.dto.UserDTO;
import com.nauam.www.apimoviesbattle.user.model.User;
import com.nauam.www.apimoviesbattle.user.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class UserSaveValidation implements ConstraintValidator<UserSave, UserDTO> {

	@Autowired
	private UserRepository repository;

	@Override
	public void initialize(UserSave constraintAnnotation) {
	}

	@Override
	public boolean isValid(UserDTO userDto, ConstraintValidatorContext context) {

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
