package br.com.rodrigojunior.money.modules.user.controllers;

import br.com.rodrigojunior.money.modules.user.entities.UserEntity;
import br.com.rodrigojunior.money.modules.user.useCases.CreateUserUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private CreateUserUseCase createUserUseCase;

    @PostMapping()
    public ResponseEntity<Object> create(@Valid @RequestBody UserEntity userEntity){
        try{
            var result = this.createUserUseCase.execute(userEntity);
            return ResponseEntity.ok().body(result);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
