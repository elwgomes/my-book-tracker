package br.com.elwgomes.mybooktracker.user.core.src.main.java.br.com.elwgomes.mybooktracker.usecases;

import br.com.elwgomes.mybooktracker.user.core.src.main.java.br.com.elwgomes.mybooktracker.domain.UserDomain;
import br.com.elwgomes.mybooktracker.user.core.src.main.java.br.com.elwgomes.mybooktracker.ports.contract.CreateUserCommand;
import br.com.elwgomes.mybooktracker.user.core.src.main.java.br.com.elwgomes.mybooktracker.ports.spi.UserDatabasePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateUserHandler implements CreateUserCommand {
    private final UserDatabasePort userDatabasePort;
    @Override
    public void execute(UserDomain user) {
        userDatabasePort.create(user);
    }
}
