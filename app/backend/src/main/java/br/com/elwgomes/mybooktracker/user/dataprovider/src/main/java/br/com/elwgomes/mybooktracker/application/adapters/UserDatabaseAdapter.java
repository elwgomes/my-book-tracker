package br.com.elwgomes.mybooktracker.user.dataprovider.src.main.java.br.com.elwgomes.mybooktracker.application.adapters;

import br.com.elwgomes.mybooktracker.user.core.src.main.java.br.com.elwgomes.mybooktracker.domain.UserDomain;
import br.com.elwgomes.mybooktracker.user.core.src.main.java.br.com.elwgomes.mybooktracker.ports.spi.UserDatabasePort;
import br.com.elwgomes.mybooktracker.user.dataprovider.src.main.java.br.com.elwgomes.mybooktracker.application.repository.UserJpaRepository;
import br.com.elwgomes.mybooktracker.user.dataprovider.src.main.java.br.com.elwgomes.mybooktracker.application.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Date;

import static br.com.elwgomes.mybooktracker.user.core.src.main.java.br.com.elwgomes.mybooktracker.domain.UserRole.STANDARD;

@Service @Primary
@RequiredArgsConstructor
public class UserDatabaseAdapter implements UserDatabasePort {
    private final UserJpaRepository jpaRepository;
    @Override
    public void create(UserDomain userDomain) {
        userDomain.setRole(STANDARD);
        userDomain.setCreatedAt(new Date());
        jpaRepository.save(UserMapper.INSTANCE.toPersistence(userDomain));
    }
}
