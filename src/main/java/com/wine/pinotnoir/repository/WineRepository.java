package com.wine.pinotnoir.repository;

import com.wine.pinotnoir.entity.WineEntity;
import com.wine.pinotnoir.entity.WineID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WineRepository extends JpaRepository<WineEntity, WineID> {
}
