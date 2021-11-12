package com.wine.pinotnoir.entity;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WineID implements Serializable {
    private String name;
    private int vintage;
}
