package com.soma.customercrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soma.customercrud.model.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
