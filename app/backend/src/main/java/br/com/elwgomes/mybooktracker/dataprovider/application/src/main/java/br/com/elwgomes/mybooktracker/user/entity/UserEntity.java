package br.com.elwgomes.mybooktracker.dataprovider.application.src.main.java.br.com.elwgomes.mybooktracker.user.entity;

import br.com.elwgomes.mybooktracker.core.src.main.java.br.com.elwgomes.mybooktracker.user.domain.UserRole;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_user")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserEntity implements UserDetails, Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @EqualsAndHashCode.Include
    public Long id;

    @Column(unique = true, nullable = false, length = 32)
    public String username;

    @Column(nullable = false, length = 64)
    public String password;

    @Column(unique = true, nullable = false, length = 64)
    public String email;

    @Column(nullable = false)
    public Date createdAt;

    public Date updatedAt;

    @Enumerated(EnumType.STRING)
    public UserRole role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRole.ADMIN) {
            return List.of(new SimpleGrantedAuthority("ADMIN"), new SimpleGrantedAuthority("STAFF"), new SimpleGrantedAuthority("STANDARD"));
        }
        if (this. role == UserRole.STAFF) {
            return List.of(new SimpleGrantedAuthority("STAFF"), new SimpleGrantedAuthority("STANDARD"));
        }
        return List.of(new SimpleGrantedAuthority("STANDARD"));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
