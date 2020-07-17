package com.example.demo.web;

import com.example.demo.model.Order;
import com.example.demo.model.Taco;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.ButtonUI;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/orders/confirm")
@SessionAttributes("order")
public class ConfirmOfOrderController {

    @GetMapping
    public String viewOrder(@ModelAttribute Order order, Model model) {
        model.addAttribute("tacos", order.getTacos());

        String in[][] = new String[order.getTacos().size()][];

        int length = order.getTacos().size();
        for (int i = 0; i < length; ++i) {
            in[i] = new String[order.getTacos().get(i).getIngredients().size()];
        }

        for (int i = 0; i < length; ++i) {
            for (int j = 0; j < order.getTacos().get(i).getIngredients().size(); ++j) {
                in[i][j] = order.getTacos().get(i).getIngredients().get(j).getName();//in[i] = (String[]) order.getTacos().get(i).getIngredients().toArray();
            }
        }
        model.addAttribute("ingredients", in);

        return "orderConfirmation";
    }

    @PostMapping("/delete")
    public String deleteTaco(@ModelAttribute("taco") Taco taco) {
        System.out.println(taco);

        return "redirect:/orders";
    }
}

