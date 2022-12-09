package com.boocrun.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.boocrun.domain.Pizza;
import com.boocrun.enums.PizzaCrustEnum;
import com.boocrun.enums.PizzaSizeEnum;
import com.boocrun.repositories.ToppingRepository;

@Controller
@RequestMapping("/orders/{orderId}/pizzas")
public class PizzaController {
  private ToppingRepository toppingRepo;
  @RequestMapping(value="", method=RequestMethod.GET)
  public String pizzaGet (@PathVariable Long orderId, ModelMap model) 
  {
    model.put("pizzaSizes", PizzaSizeEnum.values());
    model.put("pizzaCrusts", PizzaCrustEnum.values());
    model.put("toppings", toppingRepo.findAll());
    
    Pizza pizza = new Pizza();
    model.put("pizza", pizza);
    
    return "pizzas";
  }
  
  @Autowired
  public void setToppingRepo(ToppingRepository toppingRepo) {
    this.toppingRepo = toppingRepo;
  }
  
}
