package com.vsemvs.project_slovakia2.controller.rest;

import com.vsemvs.project_slovakia2.model.Item;
import com.vsemvs.project_slovakia2.service.item.interfaces.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
  @author   Vitalii Krykun
  @project   NewProjSlovakia
  @class  ItemRestController
  @version  1.0.0 
  @since 7/16/2021 - 12.12
*/

@RestController
@RequestMapping("/api/items")
public class ItemRestController {

    @Autowired
    private IItemService service;

    @GetMapping("/all")
    public List<Item> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Item get(@PathVariable String id) {
        return service.get(id);
    }

    @GetMapping("/delete/{id}")
    public Item deleteOne(@PathVariable String id) {
        return service.delete(id);
    }

    @PostMapping
    public Item create(@RequestBody Item item) {
        return service.create(item);
    }

    @PutMapping
    public Item update(@RequestBody Item item) {
        return service.update(item);
    }

}
