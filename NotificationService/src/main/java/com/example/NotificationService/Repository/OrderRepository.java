package com.example.NotificationService.Repository;

import com.example.NotificationService.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}