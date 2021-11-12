package com.wine.pinotnoir.dto;

import com.wine.pinotnoir.entity.WineEntity;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;

@Getter
@Setter
public class Wine {
    private String name;

    private int vintage;

    private Integer startDrink;

    private Integer endDrink;

    private String region;

    private Float vivino;

    private Integer rankingWorld;

    private Integer rankingRegion;

    private String pairing;

    private LocalDateTime registrationDate;

    private LocalDateTime updateDate;

    private String image;

    public static Wine of(WineEntity request) {
        return new ModelMapper().map(request, Wine.class);
    }
}
