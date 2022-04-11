package com.nauam.www.apimoviesbattle.user.service;

import com.nauam.www.apimoviesbattle.login.request.SigninRequest;
import com.nauam.www.apimoviesbattle.login.request.SignupRequest;
import com.nauam.www.apimoviesbattle.login.response.Response;
import com.nauam.www.apimoviesbattle.login.response.SigninResponse;
import com.nauam.www.apimoviesbattle.security.jwt.AuthenticationFilter;
import com.nauam.www.apimoviesbattle.security.model.LoggedInUser;
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

	public Response register(SignupRequest obj) {
		User user = new User(null, obj.getUsername(), obj.getEmail(), encoder.encode(obj.getPassword()));
		repository.save(user);
		return Response.builder().message("Usuário cadastrado com sucesso!").build();
	}

	public SigninResponse authenticate(SigninRequest obj) {
		Authentication authentication = AuthenticationFilter.authentication(obj);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String token = AuthenticationFilter.token(authentication);
	
		LoggedInUser loggedInUser = (LoggedInUser) authentication.getPrincipal();

		return SigninResponse.builder().token(token).id(loggedInUser.getId())
				.username(loggedInUser.getUsername()).email(loggedInUser.getEmail()).build();
	}
	
}