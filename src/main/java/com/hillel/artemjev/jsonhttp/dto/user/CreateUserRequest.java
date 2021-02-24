package com.hillel.artemjev.jsonhttp.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateUserRequest {
    private String login;
    private String password;
    private String dateBorn;
}
