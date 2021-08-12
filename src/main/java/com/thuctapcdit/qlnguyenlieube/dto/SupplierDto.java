package com.thuctapcdit.qlnguyenlieube.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SupplierDto {

    private Long id;

    private String name;


    private String address;


    private String phone;


    private String email;


    private Integer status;


    private Date createdAt;


    private Date updatedAt;
}
