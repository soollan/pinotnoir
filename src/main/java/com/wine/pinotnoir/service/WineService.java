package com.wine.pinotnoir.service;

import com.wine.pinotnoir.dto.Wine;
import com.wine.pinotnoir.entity.WineEntity;
import com.wine.pinotnoir.entity.WineID;
import com.wine.pinotnoir.exception.CustomException;
import com.wine.pinotnoir.repository.WineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WineService {

    private final WineRepository wineRepository;

    @Autowired
    public WineService(WineRepository wineRepository) {
        this.wineRepository = wineRepository;
    }

    @Transactional(readOnly = true)
    public List<Wine> getWines() {
        List<WineEntity> getWines = wineRepository.findAll();
        List<Wine> wines = getWines.stream().map(w -> Wine.of(w)).collect(Collectors.toList());
        return wines;
    }

    @Transactional
    public WineEntity add(Wine wine) {
        WineID wineID = new WineID(wine.getName(), wine.getVintage());
        Optional<WineEntity> getWine = wineRepository.findById(wineID);
        if (getWine.isPresent()) {
            throw new CustomException();
        }
        return wineRepository.save(WineEntity.of(wine));
    }

    @Transactional
    public WineEntity save(Wine wine) {
        WineEntity result = wineRepository.save(WineEntity.of(wine));
        return result;
    }
}
