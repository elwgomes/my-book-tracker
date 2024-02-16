package br.com.elwgomes.mybooktracker.dataprovider.application.src.main.java.br.com.elwgomes.mybooktracker.user.adapters;

import br.com.elwgomes.mybooktracker.core.src.main.java.br.com.elwgomes.mybooktracker.user.domain.UserDomain;
import br.com.elwgomes.mybooktracker.core.src.main.java.br.com.elwgomes.mybooktracker.user.ports.spi.UserDatabasePort;
import br.com.elwgomes.mybooktracker.dataprovider.application.src.main.java.br.com.elwgomes.mybooktracker.user.mapper.UserMapper;
import br.com.elwgomes.mybooktracker.dataprovider.application.src.main.java.br.com.elwgomes.mybooktracker.user.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

import static br.com.elwgomes.mybooktracker.core.src.main.java.br.com.elwgomes.mybooktracker.user.domain.UserRole.STANDARD;

@Service @Primary
@RequiredArgsConstructor
public class UserDatabaseAdapter implements UserDatabasePort {
    private final UserJpaRepository jpaRepository;
    @Override
    public void create(UserDomain userDomain) {
        userDomain.setRole(STANDARD);
        userDomain.setCreatedAt(new Date());
        String encryptedPassword = new BCryptPasswordEncoder().encode(userDomain.getPassword());
        userDomain.setPassword(encryptedPassword);
        jpaRepository.save(UserMapper.INSTANCE.toPersistence(userDomain));
    }
}
