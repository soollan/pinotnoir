package com.wine.pinotnoir.service;

import com.wine.pinotnoir.dto.Wine;
import com.wine.pinotnoir.entity.WineEntity;
import com.wine.pinotnoir.repository.WineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WineService {
    @Autowired
    WineRepository wineRepository;

    @Transactional(readOnly = true)
    public List<Wine> getWines() {
        List<WineEntity> getWines = wineRepository.findAll();
        List<Wine> wines = getWines.stream().map(w -> Wine.of(w)).collect(Collectors.toList());
        return wines;
    }

    public void save(Wine wine) {

    }
}
