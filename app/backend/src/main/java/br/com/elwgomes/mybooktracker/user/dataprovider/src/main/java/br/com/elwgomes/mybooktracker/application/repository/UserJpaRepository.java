package br.com.elwgomes.mybooktracker.user.dataprovider.src.main.java.br.com.elwgomes.mybooktracker.application.repository;

import br.com.elwgomes.mybooktracker.user.dataprovider.src.main.java.br.com.elwgomes.mybooktracker.application.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
}
