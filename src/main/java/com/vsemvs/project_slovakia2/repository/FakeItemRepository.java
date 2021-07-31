package com.vsemvs.project_slovakia2.repository;

import com.vsemvs.project_slovakia2.model.Item;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/*
  @author   Vitalii Krykun
  @project   project_slovakia2
  @class  FakeItemRepository
  @version  1.0.0 
  @since 7/20/2021 - 09.55
*/
@Repository
public class FakeItemRepository {

    private LocalDateTime time = LocalDateTime.now();
    private List<Item> items = new ArrayList<>(
            Arrays.asList(
                    new Item("1", "Item 1", "Desc 1", time, time),
                    new Item("2", "Item 2", "Desc 2", time, time),
                    new Item("3", "Item 3", "Desc 3", time, time)
            )
    );

    public List<Item> getAll() {
        return items;
    }

    public Item get(String id) {
        return items.stream()
                .filter(el -> el.getId().equals(id))
                .findFirst()
                .get();
    }

    public Item create(Item item) {
        UUID uuid = UUID.randomUUID();
        item.setId(uuid.toString());
        item.setCreatedAt(LocalDateTime.now());
        item.setUpdatedAt(LocalDateTime.now());
        items.add(item);
        return item;
    }

    public Item update(Item item) {
        Item founded = this.get(item.getId());
        int index = items.indexOf(founded);
        items.remove(founded);
        item.setCreatedAt(founded.getCreatedAt());
        item.setUpdatedAt(LocalDateTime.now());
        items.add(index, item);
        return item;
    }

    public Item delete(String id) {
        Item itemToDelete = this.get(id);
        items.remove(itemToDelete);
        return itemToDelete;
    }
}
