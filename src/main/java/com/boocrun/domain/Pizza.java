package com.boocrun.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Pizza implements Comparable<Pizza>{
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
  
  
  
  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Pizza other = (Pizza) obj;
    return Objects.equals(id, other.id);
  }
  @Override
  public int compareTo(Pizza otherPizza) {
    if (this.getId() == null)
      return 1;
    if (otherPizza.getId() == null)
      return -1;
    return this.getId().compareTo(otherPizza.getId());
  }
  
  



}
