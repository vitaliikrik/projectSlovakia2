package com.vsemvs.project_slovakia2.repository;

import com.vsemvs.project_slovakia2.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/*
  @author   Vitalii Krykun
  @project   project_slovakia2
  @class  ClientMongoRepository
  @version  1.0.0 
  @since 7/30/2021 - 15.30
*/
public interface ClientMongoRepository extends MongoRepository<Client, String> {
    List<Client> findByName(String name);
}

