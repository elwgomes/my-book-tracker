package br.com.elwgomes.mybooktracker.core.src.main.java.br.com.elwgomes.mybooktracker.user.usecases;

import br.com.elwgomes.mybooktracker.core.src.main.java.br.com.elwgomes.mybooktracker.user.ports.spi.UserDatabasePort;
import br.com.elwgomes.mybooktracker.core.src.main.java.br.com.elwgomes.mybooktracker.user.domain.UserDomain;
import br.com.elwgomes.mybooktracker.core.src.main.java.br.com.elwgomes.mybooktracker.user.ports.contract.CreateUserCommand;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateUserHandler implements CreateUserCommand {
    private final UserDatabasePort userDatabasePort;
    @Override
    public void execute(UserDomain user) {
        userDatabasePort.create(user);
    }
}
