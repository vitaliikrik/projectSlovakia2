package com.vsemvs.project_slovakia2.repository;

import com.vsemvs.project_slovakia2.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

/*
  @author   Vitalii Krykun
  @project   project_slovakia2
  @class  ItemMongoRepository
  @version  1.0.0 
  @since 7/23/2021 - 09.52
*/
public interface ItemMongoRepository extends MongoRepository<Item, String> {
}
