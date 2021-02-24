package com.hillel.artemjev.jsonhttp.dto.user;

import lombok.Data;

@Data
public class LoginUserResponse {
    private String status;
    private String error;
    private String token;

    public boolean isSuccess() {
        return "ok".equalsIgnoreCase(status);
    }
}
