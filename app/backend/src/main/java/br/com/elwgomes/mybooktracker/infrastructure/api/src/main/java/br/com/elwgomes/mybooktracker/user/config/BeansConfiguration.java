package br.com.elwgomes.mybooktracker.infrastructure.api.src.main.java.br.com.elwgomes.mybooktracker.user.config;

import br.com.elwgomes.mybooktracker.core.src.main.java.br.com.elwgomes.mybooktracker.user.ports.contract.CreateUserCommand;
import br.com.elwgomes.mybooktracker.core.src.main.java.br.com.elwgomes.mybooktracker.user.ports.spi.UserDatabasePort;
import br.com.elwgomes.mybooktracker.core.src.main.java.br.com.elwgomes.mybooktracker.user.usecases.CreateUserHandler;
import br.com.elwgomes.mybooktracker.dataprovider.application.src.main.java.br.com.elwgomes.mybooktracker.user.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeansConfiguration {

    @Autowired
    private UserJpaRepository jpaRepository;

    private final UserDatabasePort userDatabasePort;

    @Bean
    public CreateUserCommand createUserCommand() {
        return new CreateUserHandler(userDatabasePort);
    }

}
