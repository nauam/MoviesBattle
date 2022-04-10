package com.nauam.www.apimoviesbattle.login.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SigninResponse {

    private String token;
    private Integer id;
    private String username;
    private String email;

}
