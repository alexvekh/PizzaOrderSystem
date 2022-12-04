package com.boocrun.domain;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Pizza {
  private Long id;
  private String size;
  private String crustType;
  private Order order;
  private Set<Topping> toppings = new HashSet<>();
  
  @Id
  @GeneratedValue
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getSize() {
    return size;
  }
  public void setSize(String size) {
    this.size = size;
  }
  public String getCrustType() {
    return crustType;
  }
  public void setCrustType(String crustType) {
    this.crustType = crustType;
  }
  
  @ManyToOne
  public Order getOrder() {
    return order;
  }
  public void setOrder(Order order) {
    this.order = order;
  }
  
  @ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="pizzas")
  public Set<Topping> getToppings() {
    return toppings;
  }
  public void setToppings(Set<Topping> toppings) {
    this.toppings = toppings;
  }
  
  



}
