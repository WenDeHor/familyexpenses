package com.example.familyexpenses.repository;

import com.example.familyexpenses.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface OrdersRepository extends JpaRepository<Order, Long> {
}
