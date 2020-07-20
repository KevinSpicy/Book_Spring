package com.example.demo.web;

import com.example.demo.dao.OrderJPARepo;
//import com.example.demo.dao.OrderRepository;
import com.example.demo.model.Order;
import com.example.demo.model.User;
import com.example.demo.properties.OrderProps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {

    private OrderJPARepo orderJPARepo;
    private OrderProps orderProps;

    @Autowired
    public OrderController(OrderJPARepo orderJPARepo, OrderProps orderProps) {
        this.orderJPARepo = orderJPARepo;
        this.orderProps = orderProps;
    }

    @GetMapping("/current")
    public String orderForm(Model model) {
        return "orderForm";
    }

    @ModelAttribute
    public Order order() {
        return new Order();
    }

    @PostMapping("/current")
    public String processOrder(Model model, @Valid Order order, BindingResult bindingResult, SessionStatus sessionStatus,
                               @AuthenticationPrincipal User user) {
        order.setUser(user);

        if(bindingResult.hasErrors()) {
            return "orderForm";
        }

        orderJPARepo.save(order);
        sessionStatus.setComplete();

        return "redirect:/";
    }

    @GetMapping
    public String ordersForUser(@AuthenticationPrincipal User user, Model model) {
        List<Order> orders = (List<Order>)orderJPARepo.findByUserOrderByPlacedAtDesc(user);
        List<Order> viewList = orders.stream().limit(orderProps.getPageSize()).collect(Collectors.toList());
        model.addAttribute("orders", viewList);
        return "orderList";
    }
}
