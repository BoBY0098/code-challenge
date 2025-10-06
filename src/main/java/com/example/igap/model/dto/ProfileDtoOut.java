package com.example.igap.model.dto;

import com.example.igap.model.entity.ProfileEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDtoOut {
    private Long id;
    private Long userId;
    private String name;
    private String surname;
    private String nationalNumber;

    public ProfileDtoOut(ProfileEntity profileEntity) {
        this.id = profileEntity.getId();
        this.userId = profileEntity.getUser().getId();
        this.name = profileEntity.getName();
        this.surname = profileEntity.getSurname();
        this.nationalNumber = profileEntity.getNationalNumber();
    }
}
