package br.com.elwgomes.mybooktracker.infrastructure.api.src.main.java.br.com.elwgomes.mybooktracker.security.services;

import br.com.elwgomes.mybooktracker.dataprovider.application.src.main.java.br.com.elwgomes.mybooktracker.user.entity.UserEntity;
import br.com.elwgomes.mybooktracker.dataprovider.application.src.main.java.br.com.elwgomes.mybooktracker.user.repository.UserJpaRepository;
import br.com.elwgomes.mybooktracker.infrastructure.api.src.main.java.br.com.elwgomes.mybooktracker.security.request.AuthenticationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements UserDetailsService {

    private final UserJpaRepository jpaRepository;

    @Lazy
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return jpaRepository.findByUsername(username);
    }

    public String login(AuthenticationRequest request) {
        System.out.println(request);
        var authToken = new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
        var authenticated = this.authenticationManager.authenticate(authToken);
        var authenticatedToken = tokenService.generateToken((UserEntity) authenticated.getPrincipal());
        return authenticatedToken;
    }

}
