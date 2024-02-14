package br.com.rodrigojunior.money.modules.user.useCases;

import br.com.rodrigojunior.money.modules.user.dto.AuthUserDTO;
import br.com.rodrigojunior.money.modules.user.dto.AuthUserResponseDTO;
import br.com.rodrigojunior.money.modules.user.repositories.UserRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

@Service
public class AuthUserUseCase {

    @Value("${security.token.secret}")
    private String secretKey;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthUserResponseDTO execute(AuthUserDTO authUserDTO) throws AuthenticationException {
        var user = this.userRepository.findByUsername(authUserDTO.getUsername())
                .orElseThrow(() -> {
                    throw new UsernameNotFoundException("Username/password incorrect");
                });

        var passwordMatches = this.passwordEncoder.matches(authUserDTO.getPassword(), user.getPassword());

        if(!passwordMatches){
            throw new AuthenticationException();
        }

        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        var expiresIn = Instant.now().plus(Duration.ofHours(2));

        var token = JWT.create().withIssuer("javagas")
                .withExpiresAt(expiresIn)
                .withSubject(user.getId().toString())
                .withClaim("roles", Arrays.asList("COMPANY"))
                .sign(algorithm);

        var authUserResponseDto = AuthUserResponseDTO.builder()
                .access_token(token)
                .expires_in(expiresIn.toEpochMilli())
                .build();

        return authUserResponseDto;
    }
}
