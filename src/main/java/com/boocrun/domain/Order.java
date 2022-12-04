package com.boocrun.domain;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="orders") 
public class Order {
  private Long id;
  private Customer customer;
  private Set<Pizza> pizzas = new HashSet<>();
  private Double finalPrice;
  
  @Id
  @GeneratedValue
  
  //@GeneratedValue(generator="myGenerator")
  //@GenericGenerator(name="myGenerator", strategy="foreign", parameters=@Parameter(value="user", name = "property"))
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  
  @ManyToOne 
  public Customer getCustomer() {
    return customer;
  }
  public void setCustomer(Customer customer) {
    this.customer = customer;
  }
  
  @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="order")
  public Set<Pizza> getPizzas() {
    return pizzas;
  }
  public void setPizzas(Set<Pizza> pizzas) {
    this.pizzas = pizzas;
  }
  public Double getFinalPrice() {
    return finalPrice;
  }
  public void setFinalPrice(Double finalPrice) {
    this.finalPrice = finalPrice;
  }
  
  
 }
