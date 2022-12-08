package com.boocrun.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.boocrun.domain.Customer;
import com.boocrun.domain.Order;
import com.boocrun.enums.PizzaSizeEnum;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/order")
public class OrderController 
{
  @RequestMapping(value="", method=RequestMethod.GET)
  public String orderGet (ModelMap model) 
  {
    model.put("pizzaSizes", PizzaSizeEnum.values());
    return "orders";
  }
  
  @RequestMapping(value="", method=RequestMethod.POST)
  public String orderPost (HttpServletRequest request, @ModelAttribute Order order, ModelMap model) {
    Customer customer = (Customer) request.getSession().getAttribute("customer");
    return "redirect:/order";
  }
}
