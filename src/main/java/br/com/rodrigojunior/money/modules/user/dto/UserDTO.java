package br.com.rodrigojunior.money.modules.user.dto;

import br.com.rodrigojunior.money.modules.user.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private UUID id;
    private String name;
    private String username;
    private String cellphone;
    private Date birthday;
}
