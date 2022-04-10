package com.nauam.www.apimoviesbattle.user.service;

import com.nauam.www.apimoviesbattle.login.model.LoggedInUser;
import com.nauam.www.apimoviesbattle.login.request.SigninRequest;
import com.nauam.www.apimoviesbattle.login.request.SignupRequest;
import com.nauam.www.apimoviesbattle.login.response.SigninResponse;
import com.nauam.www.apimoviesbattle.login.security.JWTAuthenticationFilter;
import com.nauam.www.apimoviesbattle.message.response.FieldMessage;
import com.nauam.www.apimoviesbattle.user.model.User;
import com.nauam.www.apimoviesbattle.user.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	private final UserRepository repository;
    private final PasswordEncoder encoder;

    @Autowired
    public UserService(UserRepository repository, PasswordEncoder encoder) {
		this.repository = repository;
        this.encoder = encoder;
    }

	public FieldMessage register(SignupRequest obj) {
		User user = new User(null, obj.getUsername(), obj.getEmail(), 
				encoder.encode(obj.getPassword()), obj.getName(), obj.getPicture());
		repository.save(user);
		return FieldMessage.builder().fieldName("Signup").message("Usuário cadastrado com sucesso!").build();
	}

	public SigninResponse authenticate(SigninRequest obj) {
		Authentication authentication = JWTAuthenticationFilter.authentication(obj);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String token = JWTAuthenticationFilter.token(authentication);
	
		LoggedInUser loggedInUser = (LoggedInUser) authentication.getPrincipal();

		return SigninResponse.builder().token(token).id(loggedInUser.getId())
				.username(loggedInUser.getUsername()).email(loggedInUser.getEmail()).build();
	}
	
}