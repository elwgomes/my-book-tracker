package br.com.elwgomes.mybooktracker.infrastructure.api.src.main.java.br.com.elwgomes.mybooktracker.security.services;

import br.com.elwgomes.mybooktracker.dataprovider.application.src.main.java.br.com.elwgomes.mybooktracker.user.entity.UserEntity;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String SECRET;

    public String generateToken (UserEntity user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            String token = JWT.create()
                    .withIssuer("my-book-tracker-api")
                    .withSubject(user.getUsername())
                    .withExpiresAt(LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00")))
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error while generating token.", exception);
        }
    }

    public String validateToken (String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            return JWT.require(algorithm)
                    .withIssuer("my-book-tracker-api")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTCreationException exception) {
            return "";
        }
    }

}
