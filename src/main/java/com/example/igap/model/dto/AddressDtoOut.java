package com.example.igap.model.dto;

import com.example.igap.model.entity.AddressEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDtoOut {
    private Long id;
    private String address;
    private Long cityId;
    private Long profileId;

    public AddressDtoOut(AddressEntity address) {
        this.id = address.getId();
        this.address = address.getAddress();
        this.cityId = address.getCityId();
        this.profileId = address.getProfile().getId();
    }
}
