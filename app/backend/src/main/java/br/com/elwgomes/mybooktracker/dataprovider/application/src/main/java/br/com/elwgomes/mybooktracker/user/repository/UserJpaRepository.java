package br.com.elwgomes.mybooktracker.dataprovider.application.src.main.java.br.com.elwgomes.mybooktracker.user.repository;

import br.com.elwgomes.mybooktracker.dataprovider.application.src.main.java.br.com.elwgomes.mybooktracker.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
    UserDetails findByUsername(String username);
}
