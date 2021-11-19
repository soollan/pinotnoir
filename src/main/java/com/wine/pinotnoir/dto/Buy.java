package com.wine.pinotnoir.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.wine.pinotnoir.entity.BuyEntity;
import com.wine.pinotnoir.entity.WineEntity;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;

@Getter
@Setter
public class Buy {
    private float buyPrice;

    private String buyPlace;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate buyDate;

    public static Buy of(BuyEntity request) {
        return new ModelMapper().map(request, Buy.class);
    }
}
