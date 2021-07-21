package com.vsemvs.project_slovakia2.service.item.interfaces;

import com.vsemvs.project_slovakia2.model.Item;

import java.util.List;

/*
  @author   Vitalii Krykun
  @project   project_slovakia2
  @class  IItemServoce
  @version  1.0.0 
  @since 7/18/2021 - 19.22
*/
public interface IItemService {
    List<Item> getAll();
    Item get(String id);
    Item create(Item item);
    Item update(Item item);
    Item delete(String id);
}
