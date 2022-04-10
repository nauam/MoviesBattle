package com.nauam.www.apimoviesbattle.user.service.validation;

import com.nauam.www.apimoviesbattle.user.dto.UserDTO;
import com.nauam.www.apimoviesbattle.user.model.User;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	public User fromDTO(UserDTO userDto) {
		return new User(null, userDto.getUsername(), userDto.getEmail(), userDto.getPassword(), userDto.getName(), userDto.getPicture());
	}
    
}