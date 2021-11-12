package com.wine.pinotnoir.entity;

import com.wine.pinotnoir.dto.Wine;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "wine")
@IdClass(com.wine.pinotnoir.entity.WineID.class)
public class WineEntity {

    @Id
    @Column
    private String name;

    @Id
    @Column
    private int vintage;

    @Column(name = "drink_between_begin")
    private Integer startDrink;

    @Column(name = "drink_between_end")
    private Integer endDrink;

    @Column
    private String region;

    @Column
    private Float vivino;

    @Column(name = "ranking_world")
    private Integer rankingWorld;

    @Column(name = "ranking_region")
    private Integer rankingRegion;

    @Column
    private String pairing;

    @CreationTimestamp
    @Column(name = "registration_date", updatable = false)
    private LocalDateTime registrationDate;

    @UpdateTimestamp
    @Column(name = "update_date", insertable = false)
    private LocalDateTime updateDate;

    @Column
    private String image;

    public static WineEntity of(Wine request) {
        return new ModelMapper().map(request, WineEntity.class);
    }
}
