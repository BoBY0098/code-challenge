package com.example.igap.dao;

import com.example.igap.model.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

    @Query("SELECT a FROM AddressEntity a WHERE a.id = :id")
    public Optional<AddressEntity> findById(@Param("id") Long id);
}
