package br.com.elwgomes.mybooktracker.user.dataprovider.src.main.java.br.com.elwgomes.mybooktracker.application.entity;

import br.com.elwgomes.mybooktracker.user.core.src.main.java.br.com.elwgomes.mybooktracker.domain.UserRole;
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

    @Column(nullable = false, length = 32)
    public String username;

    @Column(nullable = false, length = 32)
    public String password;

    @Column(nullable = false, length = 64)
    public String email;

    @Column(nullable = false)
    public Date createdAt;

    public Date updatedAt;

    @Enumerated(EnumType.STRING)
    public UserRole role;
}
