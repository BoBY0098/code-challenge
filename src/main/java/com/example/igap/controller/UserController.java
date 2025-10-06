package com.example.igap.controller;

import com.example.igap.model.dto.UserDtoOut;
import com.example.igap.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    /*@GetMapping(value = "/list", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDtoOut> getById() {
        return ResponseEntity.ok(service.getById(id));
    }*/


}
