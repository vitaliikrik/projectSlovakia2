package com.vsemvs.project_slovakia2.service.implementations;

import com.vsemvs.project_slovakia2.model.Client;
import com.vsemvs.project_slovakia2.repository.ClientMongoRepository;
import com.vsemvs.project_slovakia2.repository.FakeClientRepository;
import com.vsemvs.project_slovakia2.service.interfaces.IClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

/*
  @author   Vitalii Krykun
  @project   project_slovakia2
  @class  ClientServiceImpl
  @version  1.0.0 
  @since 7/30/2021 - 18.03
*/

@AllArgsConstructor
@Service
public class ClientServiceImpl implements IClientService {

    private ClientMongoRepository mongoRepository;

    @Override
    public List<Client> getAll() {
        return mongoRepository.findAll();
    }

    @Override
    public Client get(String id) {
        return mongoRepository.findById(id).get();
    }

    @Override
    public Client create(Client client) {
        client.setCreatedAt(LocalDateTime.now());
        client.setUpdatedAt(LocalDateTime.now());
        return mongoRepository.save(client);
    }

    @Override
    public Client update(Client client) {
        client.setUpdatedAt(LocalDateTime.now());
        return mongoRepository.save(client);
    }

    @Override
    public Client delete(String id) {
        Client client = this.get(id);
        mongoRepository.deleteById(id);
        return client;
    }
}
