package com.vsemvs.project_slovakia2.forms;

import com.vsemvs.project_slovakia2.model.Good;
import com.vsemvs.project_slovakia2.model.enums.DeliveryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/*
  @author   Vitalii Krykun
  @project   project_slovakia2
  @class  GoodForm
  @version  1.0.0 
  @since 7/30/2021 - 18.39
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodForm {
    private String name;
    private String description;
    private BigDecimal price;
    private List<String> deliveryTypes;

    public GoodForm(Good good) {
        this.name = good.getName();
        this.description = good.getDescription();
        this.price = good.getPrice();
        /*this.deliveryTypes = good.getDeliveryTypes().stream().map(Enum::toString)
                .collect(Collectors.joining(","));*/
    }
}
