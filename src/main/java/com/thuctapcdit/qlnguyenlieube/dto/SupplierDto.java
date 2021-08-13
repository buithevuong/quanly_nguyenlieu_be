package com.thuctapcdit.qlnguyenlieube.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.thuctapcdit.qlnguyenlieube.common.AppConstant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SupplierDto {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String address;

    @NotBlank
    @Size(min = 10, max = 10, message = "phone = 10 digit")
    private String phone;

    @Email
    private String email;


    private Integer status;


    private Date createdAt;


    private Date updatedAt;
}
