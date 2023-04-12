package com.wine.pinotnoir.repository;

import com.wine.pinotnoir.entity.WineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WineRepository extends JpaRepository<WineEntity, Long> {
    Optional<WineEntity> findByNameAndVintage(String name, int vintage);
}
