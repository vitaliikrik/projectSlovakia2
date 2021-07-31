package com.vsemvs.project_slovakia2.controller.gui;

/*
  @author   Vitalii Krykun
  @project   project_slovakia2
  @class  OrderGuiController
  @version  1.0.0 
  @since 7/30/2021 - 18.17
*/

import com.vsemvs.project_slovakia2.forms.OrderForm;
import com.vsemvs.project_slovakia2.forms.OrderReadForm;
import com.vsemvs.project_slovakia2.model.Client;
import com.vsemvs.project_slovakia2.model.Good;
import com.vsemvs.project_slovakia2.model.Order;
import com.vsemvs.project_slovakia2.model.enums.DeliveryType;
import com.vsemvs.project_slovakia2.repository.ClientMongoRepository;
import com.vsemvs.project_slovakia2.repository.GoodMongoRepository;
import com.vsemvs.project_slovakia2.service.interfaces.IClientService;
import com.vsemvs.project_slovakia2.service.interfaces.IGoodService;
import com.vsemvs.project_slovakia2.service.interfaces.IOrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/gui/orders")
@AllArgsConstructor
public class OrderGuiController {

    private IOrderService orderService;
    private IClientService clientService;
    private ClientMongoRepository clientMongoRepository;
    private IGoodService goodService;
    private GoodMongoRepository goodMongoRepository;

    @RequestMapping("/all")
    public String getAll(Model model) {
        List<OrderReadForm> orderForms = orderService.getAll().stream()
                .map(OrderReadForm::new)
                .collect(Collectors.toList());
        model.addAttribute("orders", orderForms);
        return "orders";
    }

    @RequestMapping("/delete/{id}")
    public ModelAndView delete(ModelMap model, @PathVariable String id) {
        orderService.delete(id);
        return new ModelAndView("redirect:/gui/orders/all", model);
    }

    @RequestMapping("/create")
    public String create(ModelMap model) {
        //!!!!!!!!!!!!!!!!!!!!! GET CLIENT AND GOOD AS LISTS!!!!!!!!!!!!!!!!!!!!!!
        OrderForm formToCreate = new OrderForm();
        model.addAttribute("form", formToCreate);
        return "order-create";
    }

    @PostMapping("/create")
    public String create(ModelMap model, @ModelAttribute("form") OrderForm form, RedirectAttributes attr) {
        attr.addFlashAttribute("form", form);
        return "redirect:/gui/orders/create2";
    }

    @RequestMapping("/create2")
    public String create2(Model model) {
        OrderForm formToCreate = (OrderForm) model.getAttribute("form");
        Good good = goodMongoRepository.findByName(formToCreate.getGood()).get(0);
        Map<String, String> validDeliveryTypes = new LinkedHashMap<>();
        good.getDeliveryTypes().stream()
                .map(Enum::toString)
                .forEach(stringDeliveryType -> validDeliveryTypes.put(stringDeliveryType, stringDeliveryType));
        model.addAttribute("validDeliveryTypes", validDeliveryTypes);
        model.addAttribute("form", formToCreate);
        return "order-create2";
    }

    @PostMapping("/create2")
    public ModelAndView create2(ModelMap model, @ModelAttribute("form") OrderForm form) {
        DeliveryType deliveryTypeSelected = DeliveryType.valueOf(form.getDeliveryType());
        Client client = clientMongoRepository.findByName(form.getClient()).get(0);
        Good good = goodMongoRepository.findByName(form.getGood()).get(0);
        Order order = new Order(client, good, deliveryTypeSelected, form.getAmount(), LocalDate.now(),
                form.getDescription());//hardcoded date
        orderService.create(order);
        return new ModelAndView("redirect:/gui/orders/all", model);
    }

    @RequestMapping("/update/{id}")
    public String update(ModelMap model, @PathVariable String id) {
        //!!!!!!!!!!!!!!!!!!!!! GET CLIENT AND GOOD AS LISTS!!!!!!!!!!!!!!!!!!!!!!
        Order order = orderService.get(id);
        OrderForm orderForm = new OrderForm(order);
        model.addAttribute("form", orderForm);
        return "order-update";
    }

    @PostMapping("/update/{id}")
    public String update(ModelMap model, @ModelAttribute("form") OrderForm form, @PathVariable String id, RedirectAttributes attr) {
        attr.addFlashAttribute("form", form);
        return String.format("redirect:/gui/orders/update2/%s", id);
    }

    @RequestMapping("/update2/{id}")
    public String update2(Model model, @PathVariable String id) {
        Order order = orderService.get(id);
        OrderForm formToUpdate = (OrderForm) model.getAttribute("form");
        formToUpdate.setDescription(order.getDescription());
        formToUpdate.setAmount(order.getAmount());
        formToUpdate.setDeliveryType(order.getDeliveryType().toString());
        formToUpdate.setPurchaseDate(order.getPurchaseDate().toString());
        Good good = goodMongoRepository.findByName(formToUpdate.getGood()).get(0);
        Map<String, String> validDeliveryTypes = new LinkedHashMap<>();
        good.getDeliveryTypes().stream()
                .map(Enum::toString)
                .forEach(stringDeliveryType -> validDeliveryTypes.put(stringDeliveryType, stringDeliveryType));
        model.addAttribute("validDeliveryTypes", validDeliveryTypes);
        model.addAttribute("form", formToUpdate);
        return "order-update2";
    }

    @PostMapping("/update2/{id}")
    public ModelAndView update2(ModelMap model, @ModelAttribute("form") OrderForm form, @PathVariable String id) {
        Order order = orderService.get(id);
        DeliveryType deliveryTypeSelected = DeliveryType.valueOf(form.getDeliveryType());
        Client client = clientMongoRepository.findByName(form.getClient()).get(0);
        Good good = goodMongoRepository.findByName(form.getGood()).get(0);
        order.setClient(client);
        order.setGood(good);
        order.setDeliveryType(deliveryTypeSelected);
        order.setAmount(form.getAmount());
        order.setPurchaseDate(LocalDate.now());//hardcoded date
        order.setDescription(form.getDescription());
        orderService.update(order);
        return new ModelAndView("redirect:/gui/orders/all", model);
    }
}
