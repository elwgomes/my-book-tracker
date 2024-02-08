package br.com.elwgomes.mybooktracker.user.infrastructure.src.main.java.br.com.elwgomes.mybooktracker.response;

import br.com.elwgomes.mybooktracker.user.core.src.main.java.br.com.elwgomes.mybooktracker.domain.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    public String username;
    public String email;
    public UserRole role;
}
