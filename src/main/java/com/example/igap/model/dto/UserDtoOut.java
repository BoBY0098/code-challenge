package com.example.igap.model.dto;

import com.example.igap.model.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoOut {
    private Long userId;
    private String username;

    public UserDtoOut(UserEntity user) {
        this.userId = user.getId();
        this.username = user.getUsername();
    }
}
