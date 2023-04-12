package com.wine.pinotnoir.service;

import com.wine.pinotnoir.dto.Wine;
import com.wine.pinotnoir.entity.WineEntity;
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
    public WineEntity save(Wine wine) {
        Optional<WineEntity> savedWine = wineRepository.findByNameAndVintage(wine.getName(), wine.getVintage());
        if (savedWine.isPresent()) {
            WineEntity getWine = savedWine.get();
            getWine.setCount(getWine.getCount() + wine.getCount());

            if (wine.getPrice() > getWine.getPrice()) {
                getWine.setPrice(wine.getPrice());
                getWine.setPlace((wine.getPlace()));
                getWine.setMemo(wine.getMemo());
                getWine.setBuyDate(wine.getBuyDate());
            }

            return savedWine.get();
        }

        return wineRepository.save(WineEntity.of(wine));
    }

    @Transactional
    public void delete(Wine wine) {
        wineRepository.delete(WineEntity.of(wine));
    }
}
