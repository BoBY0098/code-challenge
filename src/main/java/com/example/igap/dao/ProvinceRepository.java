package com.example.igap.dao;

import com.example.igap.model.entity.ProvinceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends JpaRepository<ProvinceEntity, Long> {
}
