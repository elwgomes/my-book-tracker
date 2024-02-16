package br.com.elwgomes.mybooktracker.infrastructure.api.src.main.java.br.com.elwgomes.mybooktracker.user.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserControllerResponse<D>{

    private String status;
    private String code;
    private String message;
    private D data;

    public UserControllerResponse(String status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
