package com.example.OrderService.Kafka;

import com.example.OrderService.Kafka.Events.OrderCreatedEvent;
import com.example.OrderService.Model.Order;
import com.example.OrderService.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class KafkaProducer {

    private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;
    @Autowired
    private OrderRepository orderRepository;

    public KafkaProducer(KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public Order sendMessage(Order order){
        Order savedOrder = orderRepository.save(order);

        OrderCreatedEvent event = new OrderCreatedEvent();
        event.setOrderId(savedOrder.getId());
        event.setProductName(savedOrder.getProductName());
        event.setCreatedAt(LocalDateTime.now());

        kafkaTemplate.send("order_created", event);

        return savedOrder;
    }
}