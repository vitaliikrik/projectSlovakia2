package com.vsemvs.project_slovakia2.service.item.implementations;

import com.vsemvs.project_slovakia2.model.Item;
import com.vsemvs.project_slovakia2.repository.FakeItemRepository;
import com.vsemvs.project_slovakia2.service.item.interfaces.IItemService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/*
  @author   Vitalii Krykun
  @project   project_slovakia2
  @class  ItemServiceImpl
  @version  1.0.0 
  @since 7/18/2021 - 19.27
*/

@AllArgsConstructor
@Service
public class ItemServiceImpl implements IItemService {

    private FakeItemRepository repository;

    @Override
    public List<Item> getAll() {
        return repository.getAll();
    }

    @Override
    public Item get(String id) {
        return repository.get(id);
    }

    @Override
    public Item create(Item item) {
        return repository.create(item);
    }

    @Override
    public Item update(Item item) {
        return repository.update(item);
    }

    @Override
    public Item delete(String id) {
        return repository.delete(id);
    }
}
