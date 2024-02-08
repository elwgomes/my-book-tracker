package br.com.elwgomes.mybooktracker.user.core.src.main.java.br.com.elwgomes.mybooktracker.ports.spi;

import br.com.elwgomes.mybooktracker.user.core.src.main.java.br.com.elwgomes.mybooktracker.domain.UserDomain;

public interface UserDatabasePort {

    void create(UserDomain userDomain);

}
