package com.thuctapcdit.qlnguyenlieube.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SuccessRestDto {
    private static final Integer code = 200;
    private String message;
    private Object data;

}
