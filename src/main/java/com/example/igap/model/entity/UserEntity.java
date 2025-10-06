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
@Table(name = "app_user")
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity extends BaseEntity {

    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column
    private boolean deleted;

    //Use bidirectional relationship to avoid EAGER fetch in @OneToOne
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProfileEntity> profiles = new HashSet<>();
}
