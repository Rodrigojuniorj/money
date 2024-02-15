package br.com.rodrigojunior.money.modules.user.useCases;

import br.com.rodrigojunior.money.modules.user.dto.ConfirmCodeDTO;
import br.com.rodrigojunior.money.modules.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Service
public class ConfirmCodeUseCase {

    @Autowired
    private UserRepository userRepository;

    public String execute(ConfirmCodeDTO confirmCodeDTO) throws Exception {

        var user = this.userRepository.findByEmail(confirmCodeDTO.getEmail());

        Integer validate = user.getValidate();

        if(validate != null) {
            throw new Exception("Esse usuário já está válido.");
        }

        if(user == null){
            throw new Exception("Os dados informados estão errados");
        }

        if(!user.getCode().equals(confirmCodeDTO.getCode())) {
            throw new Exception("O código informado está incorreto!");
        }

        LocalDateTime timestamp = LocalDateTime.now();

        if(!timestamp.isBefore(user.getExpiredCode())){
            throw new Exception("O código informado já está vencido, por favor, gere outro!");
        }

        user.setValidate(1);
        this.userRepository.save(user);

        return "Código confirmado com sucesso";
    }
}
