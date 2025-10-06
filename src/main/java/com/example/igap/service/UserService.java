package com.example.igap.service;

import com.example.igap.dao.UserRepository;
import com.example.igap.model.dto.UserDtoOut;
import com.example.igap.model.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public Page<UserDtoOut> getUsers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<UserEntity> userEntities = repository.findAllUsersPaginated(pageable);
        return userEntities.map(UserDtoOut::new);
    }
}
