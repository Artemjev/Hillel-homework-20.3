package com.hillel.artemjev.jsonhttp.dto.contacts;

import lombok.Data;

import java.util.List;

@Data
public class PostContactsResponse {
    private String status;
    private String error;
    private List<Contact> contacts;

    @Data
    public static class Contact {
        private Integer id;
        private String name;
        private String value;
        private String type;
    }
}
