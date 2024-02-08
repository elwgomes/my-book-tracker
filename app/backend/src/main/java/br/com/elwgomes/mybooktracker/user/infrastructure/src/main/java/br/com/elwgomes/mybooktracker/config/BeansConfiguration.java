package br.com.elwgomes.mybooktracker.user.infrastructure.src.main.java.br.com.elwgomes.mybooktracker.config;

import br.com.elwgomes.mybooktracker.user.core.src.main.java.br.com.elwgomes.mybooktracker.ports.contract.CreateUserCommand;
import br.com.elwgomes.mybooktracker.user.core.src.main.java.br.com.elwgomes.mybooktracker.ports.spi.UserDatabasePort;
import br.com.elwgomes.mybooktracker.user.core.src.main.java.br.com.elwgomes.mybooktracker.usecases.CreateUserHandler;
import br.com.elwgomes.mybooktracker.user.dataprovider.src.main.java.br.com.elwgomes.mybooktracker.application.repository.UserJpaRepository;
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
