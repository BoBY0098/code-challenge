package com.example.igap.controller;

import com.example.igap.model.dto.AddressDtoIn;
import com.example.igap.model.dto.AddressDtoOut;
import com.example.igap.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService service;

    @PostMapping(value = "/addAddressToProfile", consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AddressDtoOut> createAndAddAddressToProfile(@RequestBody AddressDtoIn addressDtoIn) {
        return ResponseEntity.ok(service.createAndAddAddressToProfile(addressDtoIn));
    }
}
