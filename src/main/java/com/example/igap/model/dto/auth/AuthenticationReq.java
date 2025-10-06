package com.example.igap.model.dto.auth;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationReq {

    private String username;
    private String password;
}
