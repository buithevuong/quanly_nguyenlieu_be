package com.thuctapcdit.qlnguyenlieube.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.thuctapcdit.qlnguyenlieube.common.AppConstant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    private Long id;

    private String name;

    private String gender;

    private LocalDate birth;

    @Pattern(regexp = AppConstant.REGEX_PHONE)
    private String phone;

    @Email
    private String email;

    @Size(min = 8, message = "password > 8 digit")
    private String password;

    private Integer status;

    private String token;

    private Date tokenExpired;

    private Date createdAt;

    private Date updatedAt;
}
