package com.thuctapcdit.qlnguyenlieube.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WarningThresholdDto {

    private Long id;

    private String name;

    private Float threshold;

    private String color;

    private Date createdAt;

    private Date updatedAt;
}
