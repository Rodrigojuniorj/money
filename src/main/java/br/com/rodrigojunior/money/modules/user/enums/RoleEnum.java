package br.com.rodrigojunior.money.modules.user.enums;

public enum RoleEnum {
    USER,
    ADMIN;

    public static RoleEnum getDefault() {
        return USER; // Definindo o papel padrão como User
    }
}
