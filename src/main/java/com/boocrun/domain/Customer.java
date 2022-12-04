package com.boocrun.domain;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Customer {
  private Long id;
  private String firstName;
  private String lastName;
  private String emailaddress;
  private Set<Order> orders = new HashSet<>();
  
  @Id
  @GeneratedValue
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getFirstName() {
    return firstName;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  public String getLastName() {
    return lastName;
  }
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  public String getEmailaddress() {
    return emailaddress;
  }
  public void setEmailaddress(String emailaddress) {
    this.emailaddress = emailaddress;
  }
  
  @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="customer")  
  public Set<Order> getOrders() {
    return orders;
  }
  public void setOrders(Set<Order> orders) {
    this.orders = orders;
  }
}
