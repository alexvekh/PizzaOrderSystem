package com.boocrun.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boocrun.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
