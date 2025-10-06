package com.example.igap.service;

import com.example.igap.dao.AddressRepository;
import com.example.igap.model.dto.AddressDtoIn;
import com.example.igap.model.dto.AddressDtoOut;
import com.example.igap.model.entity.AddressEntity;
import com.example.igap.model.entity.ProfileEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository repository;
    private final ProfileService profileService;

    public AddressDtoOut addAddress(Long id) {
        Optional<AddressEntity> address = repository.findById(id);
        if (address.isEmpty()) {
            throw new SecurityException("Address not found");
        }
        return new AddressDtoOut(address.get());
    }

    public AddressDtoOut createAndAddAddressToProfile(AddressDtoIn  addressDtoIn) {
        ProfileEntity profile = profileService.getProfile(addressDtoIn.getProfileId());
        AddressEntity addressEntity = addressDtoIn.mapToEntity(profile);
        repository.save(addressEntity);
        return new AddressDtoOut(addressEntity);
    }
}
