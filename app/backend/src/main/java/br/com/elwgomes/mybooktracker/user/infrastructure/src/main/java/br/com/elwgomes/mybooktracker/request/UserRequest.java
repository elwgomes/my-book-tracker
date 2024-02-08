package br.com.elwgomes.mybooktracker.user.infrastructure.src.main.java.br.com.elwgomes.mybooktracker.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    public String username;
    public String password;
    public String email;

}
