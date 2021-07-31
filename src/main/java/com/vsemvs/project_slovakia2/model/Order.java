package com.vsemvs.project_slovakia2.model;

import com.vsemvs.project_slovakia2.model.enums.DeliveryType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/*
  @author   Vitalii Krykun
  @project   project_slovakia2
  @class  Order
  @version  1.0.0 
  @since 7/30/2021 - 15.12
*/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Order {

    @Id
    private String id;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Client client;
    private Good good;
    private DeliveryType deliveryType;
    private int amount;
    private LocalDate purchaseDate;

    public Order(Client client, Good good, DeliveryType deliveryType, int amount, LocalDate purchaseDate, String description) {
        this.client = client;
        this.good = good;
        this.deliveryType = deliveryType;
        this.amount = amount;
        this.purchaseDate = purchaseDate;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return getId().equals(order.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
