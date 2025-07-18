package com.example.OrderService.Repository;

import com.example.OrderService.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAll();

    @Modifying
    @Transactional
    void deleteById(Long id);
    Optional<Order> findById(Long id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Order")
    void clearAll();
}