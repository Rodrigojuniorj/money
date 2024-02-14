package br.com.rodrigojunior.money.modules.user.dto;

import lombok.Data;

@Data
public class ConfirmCodeDTO {
    private String email;
    private String code;
}
