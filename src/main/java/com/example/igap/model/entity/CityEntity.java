package com.example.igap.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "city")
@AllArgsConstructor
@NoArgsConstructor
public class CityEntity extends BaseEntity{

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "province_id", unique = true)
    private ProvinceEntity province;
}
