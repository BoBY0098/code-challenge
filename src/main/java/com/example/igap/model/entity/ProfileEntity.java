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
@Table(name = "profile")
@AllArgsConstructor
@NoArgsConstructor
public class ProfileEntity extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "national_number", length = 11, unique = true, nullable = false)
    private String nationalNumber;

    //Use bidirectional relationship to avoid EAGER fetch in @OneToOne
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private UserEntity user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "profile", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<AddressEntity> addresses = new HashSet<>();
}
