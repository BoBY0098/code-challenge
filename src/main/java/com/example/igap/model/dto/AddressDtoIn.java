package com.example.igap.model.dto;

import com.example.igap.model.entity.AddressEntity;
import com.example.igap.model.entity.ProfileEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDtoIn {
    private String address;
    private Long cityId;
    private Long profileId;

    public AddressEntity mapToEntity(ProfileEntity profile) {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddress(this.address);
        addressEntity.setCityId(this.cityId);
        addressEntity.setProfile(profile);
        return addressEntity;
    }
}
