package com.wine.pinotnoir.entity;

import com.wine.pinotnoir.dto.Wine;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "wine")
@EqualsAndHashCode(of = "id")
//@IdClass(WineID.class)
public class WineEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "vintage")
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

    @Column
    private Integer count;

    @OneToMany(mappedBy = "wine")
    private List<BuyEntity> buyEntities;

    public static WineEntity of(Wine request) {
        return new ModelMapper().map(request, WineEntity.class);
    }
}
