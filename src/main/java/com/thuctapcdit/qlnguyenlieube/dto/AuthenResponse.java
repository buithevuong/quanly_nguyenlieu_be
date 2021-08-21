package com.thuctapcdit.qlnguyenlieube.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
public class AuthenResponse implements Serializable {

    private static final long serialVersionUID = -2044592828653569905L;

    private final String jwt;

    private Long id;

    private String email;

}
