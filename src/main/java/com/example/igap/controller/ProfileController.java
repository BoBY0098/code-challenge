package com.example.igap.controller;

import com.example.igap.model.dto.ProfileDtoIn;
import com.example.igap.model.dto.ProfileDtoOut;
import com.example.igap.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService service;

    @PostMapping(value = "/addProfileToUser", consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProfileDtoOut> addProfileToUser(@RequestBody ProfileDtoIn profileDtoIn) {
        return ResponseEntity.ok(service.createAndAddProfileToUser(profileDtoIn));
    }
}
