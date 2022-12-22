package com.boocrun.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boocrun.domain.Customer;
import com.boocrun.domain.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

  //Order findOne(Long orderId);



}
