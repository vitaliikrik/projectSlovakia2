package com.vsemvs.project_slovakia2.forms;

import com.vsemvs.project_slovakia2.model.Order;
import com.vsemvs.project_slovakia2.model.enums.DeliveryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/*
  @author   Vitalii Krykun
  @project   project_slovakia2
  @class  OrderReadForm
  @version  1.0.0 
  @since 7/31/2021 - 19.43
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderReadForm {
    private String id;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String client;
    private String good;
    private String deliveryType;
    private int amount;
    private String purchaseDate;

    public OrderReadForm(Order order) {
        this.id = order.getId();
        this.description = order.getDescription();
        this.createdAt = order.getCreatedAt();
        this.updatedAt = order.getUpdatedAt();
        this.client = order.getClient().getName();
        this.good = order.getGood().getName();
        this.deliveryType = order.getDeliveryType().toString();
        this.amount = order.getAmount();
        this.purchaseDate = order.getPurchaseDate().toString();
    }

}
