package com.example.igap.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "province")
@AllArgsConstructor
@NoArgsConstructor
public class ProvinceEntity extends BaseEntity{

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "province")
    private Set<CityEntity> cities = new HashSet<>();
}
