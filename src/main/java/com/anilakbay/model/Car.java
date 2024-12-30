package com.anilakbay.model;

import com.anilakbay.enums.CarStatusType;
import com.anilakbay.enums.CurrencyType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "car")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car extends BaseEntity {

    @Column(name = "plaka")
    private String plaka;

    @Column(name = "brand")
    private String brand; // markası

    @Column(name = "model")
    private String model;

    @Column(name = "production_year")
    private Integer productionYear; // üretim yılı

    @Column(name = "price")
    private BigDecimal price; // fiyatı

    @Column(name = "currency_type")
    @Enumerated(EnumType.STRING)
    private CurrencyType currencyType; // Bu araba hangi para biriminden satılıyor?

    @Column(name = "damage_price")
    private BigDecimal damagePrice; // hasar kaydı

    @Column(name = "car_status_type")
    @Enumerated(EnumType.STRING)
    private CarStatusType carStatusType;
}
