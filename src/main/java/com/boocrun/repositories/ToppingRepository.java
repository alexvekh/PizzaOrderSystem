package com.boocrun.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boocrun.domain.Topping;

@Repository
public interface ToppingRepository extends JpaRepository<Topping, Long>{
  
  
}
