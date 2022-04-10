package com.nauam.www.apimoviesbattle.user.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.nauam.www.apimoviesbattle.user.service.validation.UserSave;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@UserSave
public class UserDTO {
    
	@NotEmpty(message = "Username - Preenchimento obrigatório.")
	@Length(min = 5, max = 120, message = "Username está inválida.")
    private String username;

	@NotEmpty(message = "Email - Preenchimento obrigatório.")
	@Email(message = "Email está inválido.")
    private String email;

	@NotEmpty(message = "Senha - Preenchimento obrigatório.")
	@Length(min = 8, max = 120, message = "Senha está inválida.")
    private String password;

	@NotEmpty(message = "Nome - Preenchimento obrigatório.")
	@Length(min = 5, max = 120, message = "Nome está inválido.")
    private String name;

    private String picture;
    
}