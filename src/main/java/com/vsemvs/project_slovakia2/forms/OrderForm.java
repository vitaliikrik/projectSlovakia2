package com.vsemvs.project_slovakia2.forms;

import com.vsemvs.project_slovakia2.model.Client;
import com.vsemvs.project_slovakia2.model.Good;
import com.vsemvs.project_slovakia2.model.Order;
import com.vsemvs.project_slovakia2.model.enums.DeliveryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/*
  @author   Vitalii Krykun
  @project   project_slovakia2
  @class  OrderForm
  @version  1.0.0 
  @since 7/31/2021 - 14.49
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderForm {
    private String description;
    private String client;
    private String good;
    private String deliveryType;
    private int amount;
    private String purchaseDate;

    public OrderForm(Order order) {
        this.description = order.getDescription();
        this.client = order.getClient().getName();
        this.good = order.getGood().getName();
        this.deliveryType = order.getDeliveryType().toString();
        this.amount = order.getAmount();
        this.purchaseDate = order.getPurchaseDate().toString();
    }
}
