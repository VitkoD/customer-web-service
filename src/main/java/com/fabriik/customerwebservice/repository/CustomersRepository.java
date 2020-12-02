package com.fabriik.customerwebservice.repository;

import com.fabriik.customerwebservice.domain.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository<Customers,Long> {
}
