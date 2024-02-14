package br.com.rodrigojunior.money.modules.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthUserDTO {

    private String password;
    private String username;
}
