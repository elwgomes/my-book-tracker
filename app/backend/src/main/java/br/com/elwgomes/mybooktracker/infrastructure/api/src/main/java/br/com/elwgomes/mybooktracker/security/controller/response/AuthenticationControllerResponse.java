package br.com.elwgomes.mybooktracker.infrastructure.api.src.main.java.br.com.elwgomes.mybooktracker.security.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthenticationControllerResponse<D> {
    private String access_token;
    private D data;
    public AuthenticationControllerResponse(String access_token) {
        this.access_token = access_token;
    }
}
