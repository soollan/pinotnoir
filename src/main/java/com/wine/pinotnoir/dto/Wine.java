package com.wine.pinotnoir.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.wine.pinotnoir.entity.BuyEntity;
import com.wine.pinotnoir.entity.WineEntity;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.*;

import javax.persistence.Column;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime registrationDate;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateDate;

    private String image;

    private int count;

    private int minPrice;

    public static Wine of(WineEntity request) {
        ModelMapper mapper = new ModelMapper();
        Wine wine = mapper.map(request, Wine.class);
        wine.setMinPrice(request.getBuyEntities().stream().mapToInt(b -> b.getBuyPrice()).min().orElse(0));
        return wine;
    }
}
