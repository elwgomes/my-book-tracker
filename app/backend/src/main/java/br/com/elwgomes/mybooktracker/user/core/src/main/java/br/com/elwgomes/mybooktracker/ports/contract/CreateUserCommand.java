package br.com.elwgomes.mybooktracker.user.core.src.main.java.br.com.elwgomes.mybooktracker.ports.contract;

import br.com.elwgomes.mybooktracker.user.core.src.main.java.br.com.elwgomes.mybooktracker.domain.UserDomain;

public interface CreateUserCommand {
    void execute(UserDomain user);
}
