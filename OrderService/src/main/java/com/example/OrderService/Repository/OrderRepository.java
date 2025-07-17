package com.example.OrderService.Repository;

import com.example.OrderService.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAll();
    void deleteById(Long id);
    Optional<Order> findById(Long id);
}