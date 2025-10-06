package com.example.igap.service;

import com.example.igap.dao.UserRepository;
import com.example.igap.model.dto.UserDtoOut;
import com.example.igap.model.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public UserDtoOut getById(Long id) {
        Optional<UserEntity> userEntity = repository.findById(id);
        if (userEntity.isEmpty()) {
            throw new SecurityException("User not found");
        }
        return new UserDtoOut(userEntity.get());
    }

    public UserEntity getUser(Long id) {
        Optional<UserEntity> userEntity = repository.findById(id);
        if (userEntity.isEmpty()) {
            throw new SecurityException("User not found");
        }
        return userEntity.get();
    }
}
