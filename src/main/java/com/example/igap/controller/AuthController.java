package com.example.igap.controller;

import com.example.igap.model.dto.UserDtoIn;
import com.example.igap.model.dto.auth.AuthenticationReq;
import com.example.igap.model.dto.auth.AuthenticationRes;
import com.example.igap.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    @PostMapping(value = "/signUp" ,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthenticationRes> signUp(@RequestBody UserDtoIn userDtoIn){
        return ResponseEntity.ok(service.singUp(userDtoIn));
    }

    @PostMapping(value = "/signIn" ,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthenticationRes> signIn(@RequestBody AuthenticationReq authenticationReq){
        return ResponseEntity.ok(service.singIn(authenticationReq));
    }
}
