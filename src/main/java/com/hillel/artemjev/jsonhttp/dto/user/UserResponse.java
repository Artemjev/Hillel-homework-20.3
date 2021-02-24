package com.hillel.artemjev.jsonhttp.dto.user;

import lombok.Data;

import java.util.List;

@Data
public class UserResponse {
    private String status;
    private List<User> users;
    private String error;

    @Data
    public static class User {
        private String login;
        private String password;
        private String dateBorn;
    }

}
