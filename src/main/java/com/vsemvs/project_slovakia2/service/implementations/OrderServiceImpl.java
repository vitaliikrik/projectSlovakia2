package com.vsemvs.project_slovakia2.service.implementations;

import com.vsemvs.project_slovakia2.model.Order;
import com.vsemvs.project_slovakia2.repository.OrderMongoRepository;
import com.vsemvs.project_slovakia2.service.interfaces.IOrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/*
  @author   Vitalii Krykun
  @project   project_slovakia2
  @class  OrderServiceImpl
  @version  1.0.0 
  @since 7/30/2021 - 18.04
*/

@AllArgsConstructor
@Service
public class OrderServiceImpl implements IOrderService {

    private OrderMongoRepository mongoRepository;

    @Override
    public List<Order> getAll() {
        return mongoRepository.findAll();
    }

    @Override
    public Order get(String id) {
        return mongoRepository.findById(id).get();
    }

    @Override
    public Order create(Order order) {
        order.setCreatedAt(LocalDateTime.now());
        order.setUpdatedAt(LocalDateTime.now());
        return mongoRepository.save(order);
    }

    @Override
    public Order update(Order order) {
        order.setUpdatedAt(LocalDateTime.now());
        return mongoRepository.save(order);
    }

    @Override
    public Order delete(String id) {
        Order order = this.get(id);
        mongoRepository.deleteById(id);
        return order;
    }
}
