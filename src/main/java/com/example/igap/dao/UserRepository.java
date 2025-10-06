package com.example.igap.dao;

import com.example.igap.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query("SELECT u FROM UserEntity u WHERE u.username = :username")
    public Optional<UserEntity> findByUsername(@Param("username") String username);

    @Query("SELECT u FROM UserEntity u WHERE u.id = :id")
    public Optional<UserEntity> findById(@Param("id") Long id);
}
