package br.com.rodrigojunior.money.modules.user.repositories;

import br.com.rodrigojunior.money.modules.user.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByUsernameOrEmailOrCpf(String username, String email, String cpf);

    Optional<UserEntity> findByUsername(String username);
}
