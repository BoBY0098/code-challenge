package com.example.igap.model.dto;

import com.example.igap.model.entity.ProfileEntity;
import com.example.igap.model.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoOut {
    private Long userId;
    private String username;
    private ProfileDtoOut profile;

    public UserDtoOut(UserEntity user) {
        this.userId = user.getId();
        this.username = user.getUsername();
        Optional<ProfileEntity> userProfile = user.getProfiles().stream().findFirst();
        this.profile = userProfile.isPresent() ? new ProfileDtoOut(userProfile.get()) : new ProfileDtoOut();
    }
}
