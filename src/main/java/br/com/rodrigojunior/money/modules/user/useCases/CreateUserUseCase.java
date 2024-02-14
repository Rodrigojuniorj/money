package br.com.rodrigojunior.money.modules.user.useCases;

import br.com.rodrigojunior.money.exceptions.UserFoundException;
import br.com.rodrigojunior.money.modules.user.entities.UserEntity;
import br.com.rodrigojunior.money.modules.user.repositories.UserRepository;
import br.com.rodrigojunior.money.utils.CodeGenerator;
import br.com.rodrigojunior.money.utils.email.EmailService;
import br.com.rodrigojunior.money.utils.email.EmailTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCase {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailService emailService;

    public UserEntity execute(UserEntity userEntity) throws Exception {
        this.userRepository.
                findByUsernameOrEmailOrCpf(userEntity.getUsername(), userEntity.getEmail(), userEntity.getCpf())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });

        var code = CodeGenerator.generateNumberCode();

        var password = passwordEncoder.encode(userEntity.getPassword());
        userEntity.setPassword(password);
        userEntity.setCode(code);

        var user = this.userRepository.save(userEntity);

        if(user == null) {
            throw new Exception("Erro ao salvar usuário");
        }

        var htmlEmail = EmailTemplate.generateEmailConfirmationHtml(userEntity.getName(), code);

        this.emailService.sendEmail(userEntity.getEmail(), "Confirmação de código", htmlEmail);

        return user;
    }
}
