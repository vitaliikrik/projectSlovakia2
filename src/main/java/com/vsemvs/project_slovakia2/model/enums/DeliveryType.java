package com.vsemvs.project_slovakia2.model.enums;

import java.math.BigDecimal;

/*
  @author   Vitalii Krykun
  @project   project_slovakia2
  @class  DeliveryType
  @version  1.0.0 
  @since 7/19/2021 - 19.18
*/
public enum DeliveryType {
    DELIVERY_TO_HOME(new BigDecimal(100)),
    DELIVERY_TO_POST_OFFICE(new BigDecimal(50)),
    SELF_DELIVERY(new BigDecimal(0));

    private BigDecimal price;

    DeliveryType(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
