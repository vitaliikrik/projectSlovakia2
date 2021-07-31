package com.vsemvs.project_slovakia2.service.interfaces;

import com.vsemvs.project_slovakia2.model.Order;

import java.util.List;

/*
  @author   Vitalii Krykun
  @project   project_slovakia2
  @class  IOrderService
  @version  1.0.0 
  @since 7/30/2021 - 18.02
*/
public interface IOrderService {
    List<Order> getAll();
    Order get(String id);
    Order create(Order order);
    Order update(Order order);
    Order delete(String id);
}
