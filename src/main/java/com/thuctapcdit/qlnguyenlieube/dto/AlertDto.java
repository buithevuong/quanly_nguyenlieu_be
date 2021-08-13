package com.thuctapcdit.qlnguyenlieube.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlertDto {

    private Long id;

    private String title;

    private String content;

    private String color;

    private Date createdAt;

    private String materialName;

    private Float thresh_hold;

    private Integer isChecked;
}
