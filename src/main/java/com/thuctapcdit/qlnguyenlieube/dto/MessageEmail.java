package com.thuctapcdit.qlnguyenlieube.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageEmail {

    private String email;

    private String title;

    private String content;

}
