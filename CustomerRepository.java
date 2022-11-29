package com.springboot.exapmple.present.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.springboot.exapmple.present.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
