package br.com.elwgomes.mybooktracker.user.infrastructure.src.main.java.br.com.elwgomes.mybooktracker.controller;

import br.com.elwgomes.mybooktracker.user.core.src.main.java.br.com.elwgomes.mybooktracker.ports.contract.CreateUserCommand;
import br.com.elwgomes.mybooktracker.user.infrastructure.src.main.java.br.com.elwgomes.mybooktracker.controller.response.ControllerResponse;
import br.com.elwgomes.mybooktracker.user.infrastructure.src.main.java.br.com.elwgomes.mybooktracker.request.UserRequest;
import br.com.elwgomes.mybooktracker.user.infrastructure.src.main.java.br.com.elwgomes.mybooktracker.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.com.elwgomes.mybooktracker.user.infrastructure.src.main.java.br.com.elwgomes.mybooktracker.mapper.UserHttpMapper.INSTANCE;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final CreateUserCommand createUserCommand;

    @PostMapping
    public ControllerResponse<UserResponse> create(@RequestBody UserRequest request) {
        createUserCommand.execute(INSTANCE.toDomain(request));
        return new ControllerResponse<>("created", String.valueOf(HttpStatus.CREATED.value()), "User has been created");
    }

}
