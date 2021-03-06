package com.vsemvs.project_slovakia2.model;

import com.vsemvs.project_slovakia2.model.enums.DeliveryType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
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
@Document
public class Good {

    @Id
    private String id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private BigDecimal price;
    private List<DeliveryType> deliveryTypes;

    public Good(String name, String description, BigDecimal price, List<DeliveryType> deliveryTypes) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.deliveryTypes = deliveryTypes;
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
