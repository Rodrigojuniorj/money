package br.com.rodrigojunior.money.modules.user.controllers;

import br.com.rodrigojunior.money.modules.user.dto.AuthUserDTO;
import br.com.rodrigojunior.money.modules.user.useCases.AuthUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class AuthUserController {
    @Autowired
    private AuthUserUseCase authUserUseCase;

    @PostMapping("/auth")
    public ResponseEntity<Object> create(@RequestBody AuthUserDTO authCompanyDTO) {
        try{
            var result = this.authUserUseCase.execute(authCompanyDTO);
            return ResponseEntity.ok().body(result);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
