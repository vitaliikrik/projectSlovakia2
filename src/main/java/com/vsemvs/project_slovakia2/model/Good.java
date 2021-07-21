package com.vsemvs.project_slovakia2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

/*
  @author   Vitalii Krykun
  @project   project_slovakia2
  @class  Good
  @version  1.0.0 
  @since 7/19/2021 - 19.15
*/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Good {
    private String id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private double price;
    private DeliveryType deliveryType;

    public Good(String name, String description, double price, DeliveryType deliveryType) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.deliveryType = deliveryType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Good good = (Good) o;
        return getId().equals(good.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
