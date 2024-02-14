package br.com.rodrigojunior.money.exceptions;

public class UserFoundException extends  RuntimeException{
    public UserFoundException() {
        super("Usuário já existe!");
    }
}
