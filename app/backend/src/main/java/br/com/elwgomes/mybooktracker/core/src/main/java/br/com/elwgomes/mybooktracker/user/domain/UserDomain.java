package br.com.elwgomes.mybooktracker.core.src.main.java.br.com.elwgomes.mybooktracker.user.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDomain implements Serializable {
    public Long id;
    public String username;
    public String password;
    public String email;
    public Date createdAt;
    public Date updatedAt;
    public UserRole role;
}
