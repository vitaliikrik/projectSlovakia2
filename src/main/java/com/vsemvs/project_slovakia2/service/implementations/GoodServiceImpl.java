package com.vsemvs.project_slovakia2.service.implementations;

import com.vsemvs.project_slovakia2.model.Good;
import com.vsemvs.project_slovakia2.repository.FakeGoodRepository;
import com.vsemvs.project_slovakia2.repository.GoodMongoRepository;
import com.vsemvs.project_slovakia2.service.interfaces.IGoodService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

/*
  @author   Vitalii Krykun
  @project   project_slovakia2
  @class  IGoodServiceImpl
  @version  1.0.0 
  @since 7/19/2021 - 19.12
*/

@AllArgsConstructor
@Service
public class GoodServiceImpl implements IGoodService {

    private GoodMongoRepository mongoRepository;

    @Override
    public List<Good> getAll() {
        return mongoRepository.findAll();
    }

    @Override
    public Good get(String id) {
        return mongoRepository.findById(id).get();
    }

    @Override
    public Good create(Good good) {
        good.setCreatedAt(LocalDateTime.now());
        good.setUpdatedAt(LocalDateTime.now());
        return mongoRepository.save(good);
    }

    @Override
    public Good update(Good good) {
        good.setUpdatedAt(LocalDateTime.now());
        return mongoRepository.save(good);
    }

    @Override
    public Good delete(String id) {
        Good good = this.get(id);
        mongoRepository.deleteById(id);
        return good;
    }
}
