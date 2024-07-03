package com.example.Cifrado2.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
/**
 * Data transfer object for the count of the cars
 */
public class CountDTO {
    private Long count;
    private String message;

    public CountDTO() {
    }

}
