package com.vsemvs.project_slovakia2.service.good.implementations;

import com.vsemvs.project_slovakia2.model.DeliveryType;
import com.vsemvs.project_slovakia2.model.Good;
import com.vsemvs.project_slovakia2.model.Item;
import com.vsemvs.project_slovakia2.service.good.interfaces.IGoodService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
  @author   Vitalii Krykun
  @project   project_slovakia2
  @class  IGoodServiceImpl
  @version  1.0.0 
  @since 7/19/2021 - 19.12
*/

@Service
public class GoodServiceImpl implements IGoodService {

    private LocalDateTime time = LocalDateTime.now();
    private List<Good> goods = new ArrayList<>(
            Arrays.asList(
                    new Good("0", "Good 0", "Desc 0", time, time, 20d, DeliveryType.DELIVERY_TO_HOME),
                    new Good("1", "Good 1", "Desc 1", time, time, 15d, DeliveryType.SELF_DELIVERY)
            )
    );

    @Override
    public List<Good> getAll() {
        return goods;
    }

    @Override
    public Good get(String id) {
        return goods.stream()
                .filter(el -> el.getId().equals(id))
                .findFirst()
                .get();
    }

    @Override
    public Good create(Good item) {
        return null;
    }

    @Override
    public Good update(Good item) {
        return null;
    }

    @Override
    public Good delete(String id) {
        Good good =  this.get(id);
        goods.remove(good);
        return good;
    }
}
