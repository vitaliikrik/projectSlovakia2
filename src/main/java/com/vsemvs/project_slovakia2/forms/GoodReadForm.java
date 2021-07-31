package com.vsemvs.project_slovakia2.forms;

import com.vsemvs.project_slovakia2.model.Good;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

/*
  @author   Vitalii Krykun
  @project   project_slovakia2
  @class  GoodReadForm
  @version  1.0.0 
  @since 7/30/2021 - 19.37
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodReadForm {
    private String id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private BigDecimal price;
    private String deliveryTypes;

    public GoodReadForm(Good good) {
        this.id = good.getId();
        this.createdAt = good.getCreatedAt();
        this.updatedAt = good.getUpdatedAt();
        this.name = good.getName();
        this.description = good.getDescription();
        this.price = good.getPrice();
        this.deliveryTypes = good.getDeliveryTypes().stream().map(Enum::toString)
                .collect(Collectors.joining(",\n"));
    }
}
