package com.vsemvs.project_slovakia2.controller.gui;

/*
  @author   Vitalii Krykun
  @project   project_slovakia2
  @class  GoodGuiController
  @version  1.0.0 
  @since 7/30/2021 - 18.16
*/

import com.vsemvs.project_slovakia2.forms.GoodForm;
import com.vsemvs.project_slovakia2.forms.GoodReadForm;
import com.vsemvs.project_slovakia2.model.Good;
import com.vsemvs.project_slovakia2.model.enums.DeliveryType;
import com.vsemvs.project_slovakia2.service.interfaces.IGoodService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/gui/goods")
@AllArgsConstructor
public class GoodGuiController {

    private IGoodService service;

    @RequestMapping("/all")
    public String getAll(Model model) {
        List<GoodReadForm> goodForms = service.getAll().stream()
                .map(GoodReadForm::new)
                .collect(Collectors.toList());
        model.addAttribute("goods", goodForms);
        return "goods";
    }

    @RequestMapping("/delete/{id}")
    public ModelAndView delete(ModelMap model, @PathVariable String id) {
        service.delete(id);
        return new ModelAndView("redirect:/gui/goods/all", model);
    }

    @RequestMapping("/create")
    public String create(ModelMap model) {
        GoodForm formToCreate = new GoodForm();
        model.addAttribute("allDeliveryTypes", findAllDeliveryTypes());
        model.addAttribute("form", formToCreate);
        return "good-create";
    }

    @PostMapping("/create")
    public ModelAndView create(ModelMap model, @ModelAttribute("form") GoodForm form) {
        List<DeliveryType> deliveryTypesSelected = form.getDeliveryTypes().stream()
                .map(DeliveryType::valueOf)
                .collect(Collectors.toList());
        Good good = new Good(form.getName(), form.getDescription(), form.getPrice(),
                deliveryTypesSelected);
        service.create(good);
        return new ModelAndView("redirect:/gui/goods/all", model);
    }

    @RequestMapping("/update/{id}")
    public String update(ModelMap model, @PathVariable String id) {
        Good good = service.get(id);
        GoodForm formToUpdate = new GoodForm(good.getName(), good.getDescription(),
                good.getPrice(), good.getDeliveryTypes().stream()
                .map(Enum::toString)
                .collect(Collectors.toList())
        );
        model.addAttribute("allDeliveryTypes", findAllDeliveryTypes());
        model.addAttribute("form", formToUpdate);
        return "good-update";
    }

    @PostMapping("/update/{id}")
    public ModelAndView update(ModelMap model, @ModelAttribute("form") GoodForm form, @PathVariable String id) {
        Good good = service.get(id);
        good.setName(form.getName());
        good.setDescription(form.getDescription());
        good.setPrice(form.getPrice());
        List<DeliveryType> deliveryTypesSelected = form.getDeliveryTypes().stream()
                .map(DeliveryType::valueOf)
                .collect(Collectors.toList());
        good.setDeliveryTypes(deliveryTypesSelected);
        service.update(good);
        return new ModelAndView("redirect:/gui/goods/all", model);
    }

    private Map<String, String> findAllDeliveryTypes() {
        Map<String, String> allDeliveryTypes = new LinkedHashMap<>();
        Arrays.stream(DeliveryType.values())
                .map(Enum::toString)
                .forEach(value -> allDeliveryTypes.put(value, value));
        return allDeliveryTypes;
    }
}
