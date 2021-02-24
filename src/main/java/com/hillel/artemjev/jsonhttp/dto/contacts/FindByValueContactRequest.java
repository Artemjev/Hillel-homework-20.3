package com.hillel.artemjev.jsonhttp.dto.contacts;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FindByValueContactRequest {
    private String value;
}
