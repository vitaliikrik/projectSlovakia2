package com.vsemvs.project_slovakia2.controller.gui;

/*
  @author   Vitalii Krykun
  @project   project_slovakia2
  @class  ItemGuiController
  @version  1.0.0 
  @since 7/20/2021 - 11.35
*/

import com.vsemvs.project_slovakia2.forms.ItemCreateForm;
import com.vsemvs.project_slovakia2.model.Item;
import com.vsemvs.project_slovakia2.service.item.interfaces.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
        return "items";
    }

    @RequestMapping("/delete/{id}")
    public ModelAndView delete(ModelMap model, @PathVariable String id) {
        service.delete(id);
        return new ModelAndView("redirect:/gui/items/all", model);
    }

    @RequestMapping("/create")
    public String create(ModelMap model) {
        //service.create();
        ItemCreateForm formToCreate = new ItemCreateForm();
        model.addAttribute("form", formToCreate);
        return "item-create";
    }

    @PostMapping("/create")
    public ModelAndView create(ModelMap model, @ModelAttribute("form") ItemCreateForm form) {
        Item item = new Item(form.getName(), form.getDescription());
        service.create(item);
        return new ModelAndView("redirect:/gui/items/all", model);
    }

    @RequestMapping("/update/{id}")
    public String update(ModelMap model, @PathVariable String id) {
        Item item = service.get(id);
        ItemCreateForm formToUpdate = new ItemCreateForm(item.getName(),
                item.getDescription());
        model.addAttribute("form", formToUpdate);
        return "item-update";
    }

    @PostMapping("/update/{id}")
    public ModelAndView update(ModelMap model, @ModelAttribute("form") ItemCreateForm form, @PathVariable String id) {
        Item item = service.get(id);
        item.setName(form.getName());
        item.setDescription(form.getDescription());
        service.update(item);
        return new ModelAndView("redirect:/gui/items/all", model);
    }
}
