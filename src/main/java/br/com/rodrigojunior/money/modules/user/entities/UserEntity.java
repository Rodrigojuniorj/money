package br.com.rodrigojunior.money.modules.user.entities;

import br.com.rodrigojunior.money.modules.user.enums.RoleEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;

@Entity(name = "users")
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank()
    @Pattern(regexp = "\\S+", message = "O campo [username] não deve conter espaço")
    @Column(unique = true)
    private String username;

    @NotBlank()
    private String name;

    @Email(message = "O campo [email] deve conter um e-mail válido")
    @Column(unique = true)
    private String email;

    @Length(min = 10, max= 100, message = "A senha deve conter entre (10) à (100) caracteres")
    private String password;

    @CPF(message = "O campo [cpf] deve ser válido")
    @Column(unique = true)
    private String cpf;

    @NotBlank(message = "O campo [cellphone] não pode estar em branco")
    private String cellphone;

    @NotNull(message = "O campo [birthday] não pode ser nulo")
    private Date birthday;

    private String code;

    @Column(name = "expired_code")
    private LocalDateTime expiredCode;

    private Integer validate;

    @Column(name = "forgot_password")
    private Integer forgotPassword;

    @Enumerated(EnumType.STRING)
    private RoleEnum role = RoleEnum.getDefault();

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
