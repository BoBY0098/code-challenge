package com.example.igap.model.dto;

import com.example.igap.model.entity.ProfileEntity;
import com.example.igap.model.entity.UserEntity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDtoIn {
    @NotNull(message = "User ID must not be null")
    private Long userId;
    private String name;
    private String surname;
    @Size(min = 11,max = 11, message = "National Number size should be 11")
    private String nationalNumber;

    public ProfileEntity mapToEntity(UserEntity user) {
        ProfileEntity userProfile = new ProfileEntity();
        userProfile.setName(this.name);
        userProfile.setSurname(this.surname);
        userProfile.setNationalNumber(this.nationalNumber);
        userProfile.setUser(user);
        return userProfile;
    }
}
