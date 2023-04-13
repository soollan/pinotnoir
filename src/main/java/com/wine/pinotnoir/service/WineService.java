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
    public WineEntity save(Wine inputWine) {
        return wineRepository.save(WineEntity.of(inputWine));
    }

    @Transactional
    public WineEntity update(Wine inputWine) {
        Optional<WineEntity> getWine = wineRepository.findById(inputWine.getId());
        if (getWine.isPresent()) {
            WineEntity savedWine = getWine.get();
            if (savedWine.getCount() != inputWine.getCount()) {
                savedWine.setCount(inputWine.getCount());
            }

            if (inputWine.getPrice() < savedWine.getPrice()) {
                savedWine.setPrice(inputWine.getPrice());
            }

            savedWine.setPlace((inputWine.getPlace()));
            savedWine.setBuyDate(inputWine.getBuyDate());
            savedWine.setMemo(inputWine.getMemo());
            savedWine.setImage(inputWine.getImage());
            savedWine.setName(inputWine.getName());
            savedWine.setPairing(inputWine.getPairing());
            savedWine.setRegion(inputWine.getRegion());
            savedWine.setEndDrink(inputWine.getEndDrink());
            savedWine.setRankingRegion(inputWine.getRankingRegion());
            savedWine.setRankingWorld(inputWine.getRankingWorld());
            savedWine.setStartDrink(inputWine.getStartDrink());
            savedWine.setVintage(inputWine.getVintage());
            savedWine.setVivino(inputWine.getVivino());

            return savedWine;
        }

        return wineRepository.save(WineEntity.of(inputWine));
    }

    @Transactional
    public void delete(Wine wine) {
        wineRepository.delete(WineEntity.of(wine));
    }
}
