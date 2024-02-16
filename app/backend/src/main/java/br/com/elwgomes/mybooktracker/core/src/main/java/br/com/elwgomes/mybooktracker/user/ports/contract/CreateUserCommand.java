package br.com.elwgomes.mybooktracker.core.src.main.java.br.com.elwgomes.mybooktracker.user.ports.contract;

import br.com.elwgomes.mybooktracker.core.src.main.java.br.com.elwgomes.mybooktracker.user.domain.UserDomain;

public interface CreateUserCommand {
    void execute(UserDomain user);
}
