package com.example.igap.service;

import com.example.igap.dao.ProfileRepository;
import com.example.igap.model.dto.ProfileDtoIn;
import com.example.igap.model.dto.ProfileDtoOut;
import com.example.igap.model.entity.ProfileEntity;
import com.example.igap.model.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileService {
    private final ProfileRepository repository;
   private final UserService userService;

    public ProfileDtoOut addProfile(ProfileDtoIn profileDtoIn) {
        UserEntity user = userService.getUser(profileDtoIn.getUserId());
        ProfileEntity userProfile = profileDtoIn.mapToEntity(user);
        repository.save(userProfile);
        return new ProfileDtoOut(userProfile);
    }
}
