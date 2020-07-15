package com.example.demo.web;

import com.example.demo.dao.IngredientJPARepo;
import com.example.demo.dao.TacoJPARepo;
import com.example.demo.model.Ingredient;
import com.example.demo.model.Ingredient.Type;

import com.example.demo.model.Order;
import com.example.demo.model.Taco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {

    @Autowired
    private IngredientJPARepo ingredientJPARepo;
    //private IngredientRepository ingredientRepository;

    @Autowired
    private TacoJPARepo tacoJPARepo;
    //private TacoRepository tacoRepository;

    private List<Ingredient> ingredients;

    @GetMapping
    public String showDesignForm(Model model) {
        return view(model);
    }

    @ModelAttribute
    private Order order() {
        return new Order();
    }

    @ModelAttribute
    private Taco taco() {
        return new Taco();
    }

    @PostMapping
    public String processDesign(Model model, @Valid Taco taco, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return view(model);
        }

        List<Ingredient> l =  taco.getIngredientIds()
                .stream()
                .map(x -> ingredients.stream()
                        .filter(y -> y.getId().equals(x))
                        .findFirst()
                        .orElse(null))
                .collect(Collectors.toList());

        taco.setIngredients(l);

        Order order = (Order) model.getAttribute("order");
        Taco saved = tacoJPARepo.save(taco);
        order.addTaco(saved);

        return "redirect:/orders/confirm";
    }

    private String view(Model model) {
        ingredients = (List<Ingredient>) ingredientJPARepo.findAll();

        for (Type type : Type.values()) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(type));
        }

        return "design";
    }

    private List<Ingredient> filterByType(Type type) {
        return ingredients.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
    }
}
