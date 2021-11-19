package com.wine.pinotnoir.entity;

import com.wine.pinotnoir.dto.Wine;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "buy")
@EqualsAndHashCode(of = "id")
//@IdClass(WineID.class)
public class BuyEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wine_id")
    private WineEntity wine;

    @Column(name = "buy_place")
    private String buyPlace;

    @Column(name = "buy_price")
    private int buyPrice;

    @Column(name = "buy_price_memo")
    private String buyPriceMemo;

    @Column(name = "buy_date")
    private LocalDate buyDate;

    @CreationTimestamp
    @Column(name = "registration_date", updatable = false)
    private LocalDateTime registrationDate;

    @UpdateTimestamp
    @Column(name = "update_date", insertable = false)
    private LocalDateTime updateDate;

    public static BuyEntity of(Wine request) {
        return new ModelMapper().map(request, BuyEntity.class);
    }
}
