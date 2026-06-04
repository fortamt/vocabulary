package org.example.vocabulary.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ListResponseDto {

    private Long id;
    private String name;
    private String icon;
    private int wordCount;
    private String background;

}
