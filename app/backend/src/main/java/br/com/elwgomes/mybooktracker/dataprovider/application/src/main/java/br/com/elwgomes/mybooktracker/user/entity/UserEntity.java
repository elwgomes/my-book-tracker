package br.com.elwgomes.mybooktracker.dataprovider.application.src.main.java.br.com.elwgomes.mybooktracker.user.entity;

import br.com.elwgomes.mybooktracker.core.src.main.java.br.com.elwgomes.mybooktracker.user.domain.UserRole;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_user")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @EqualsAndHashCode.Include
    public Long id;

    @Column(unique = true, nullable = false, length = 32)
    public String username;

    @Column(nullable = false, length = 32)
    public String password;

    @Column(unique = true, nullable = false, length = 64)
    public String email;

    @Column(nullable = false)
    public Date createdAt;

    public Date updatedAt;

    @Enumerated(EnumType.STRING)
    public UserRole role;
}
