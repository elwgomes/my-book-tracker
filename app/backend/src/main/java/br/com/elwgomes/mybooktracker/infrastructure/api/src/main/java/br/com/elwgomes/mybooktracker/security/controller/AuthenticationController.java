package br.com.elwgomes.mybooktracker.infrastructure.api.src.main.java.br.com.elwgomes.mybooktracker.security.controller;

import br.com.elwgomes.mybooktracker.infrastructure.api.src.main.java.br.com.elwgomes.mybooktracker.security.controller.response.AuthenticationControllerResponse;
import br.com.elwgomes.mybooktracker.infrastructure.api.src.main.java.br.com.elwgomes.mybooktracker.security.request.AuthenticationRequest;
import br.com.elwgomes.mybooktracker.infrastructure.api.src.main.java.br.com.elwgomes.mybooktracker.security.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final AuthenticationManager authenticationManager;

    @PostMapping("login")
    public AuthenticationControllerResponse login (@RequestBody AuthenticationRequest request) {
        return new AuthenticationControllerResponse(authenticationService.login(request));
    }

}
