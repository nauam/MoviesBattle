package com.nauam.www.apimoviesbattle.login.request;

import javax.validation.constraints.NotEmpty;

import com.nauam.www.apimoviesbattle.login.validation.SigninValidation;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SigninValidation
public class SigninRequest {
    
	@NotEmpty(message = "Username - Preenchimento obrigatório.")
	@Length(min = 5, max = 120, message = "Username está inválida.")
    private String username;

	@NotEmpty(message = "Senha - Preenchimento obrigatório.")
	@Length(min = 8, max = 120, message = "Senha está inválida.")
    private String password;
    
}