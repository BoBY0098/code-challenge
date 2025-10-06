package com.example.igap.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "address")
@AllArgsConstructor
@NoArgsConstructor
public class AddressEntity extends BaseEntity {

    @Column(name = "address")
    private String address;

    @Column(name = "city_id", insertable = false, updatable = false)
    private Long cityId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", unique = true)
    private CityEntity city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", unique = true)
    private ProfileEntity profile;
}
