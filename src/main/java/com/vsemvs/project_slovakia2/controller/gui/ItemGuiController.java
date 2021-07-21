package com.vsemvs.project_slovakia2.controller.gui;

/*
  @author   Vitalii Krykun
  @project   project_slovakia2
  @class  ItemGuiController
  @version  1.0.0 
  @since 7/20/2021 - 11.35
*/

import com.vsemvs.project_slovakia2.model.Item;
import com.vsemvs.project_slovakia2.service.item.interfaces.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/gui/items")
public class ItemGuiController {

    @Autowired
    IItemService service;

    @RequestMapping("/all")
    public String getAll(Model model) {

        List<Item> items = service.getAll();
        model.addAttribute("items", items);
        return "item";
    }
}
