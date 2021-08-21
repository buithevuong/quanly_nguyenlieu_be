package com.thuctapcdit.qlnguyenlieube.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthenRequest implements Serializable {
    private static final long serialVersionUID = -6732643706513481525L;

    @NotEmpty(message = "username not emty")
    private String username;
    @NotEmpty(message = "password not emty")
    private String password;


}
