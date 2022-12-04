package com.boocrun.domain;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Topping {
  private Long id;
  private String description;
  private Double price;
  private Set<Pizza> pizzas = new HashSet<>();
  
  @Id
  @GeneratedValue
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public Double getPrice() {
    return price;
  }
  public void setPrice(Double price) {
    this.price = price;
  }
  
  @ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
  @JoinTable(name="pizza_topping", 
      joinColumns=@JoinColumn(name="toppin_id"), 
      inverseJoinColumns=@JoinColumn(name="pizza_id"))
  public Set<Pizza> getPizzas() {
    return pizzas;
  }
  public void setPizzas(Set<Pizza> pizzas) {
    this.pizzas = pizzas;
  }
  
  
  
  
}
