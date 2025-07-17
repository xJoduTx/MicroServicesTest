package com.example.OrderService.Controller;

import com.example.OrderService.Kafka.KafkaProducer;
import com.example.OrderService.Model.Order;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class OrderController {

    private final KafkaProducer kafkaProducer;

    public OrderController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/orders")
    public Order createOrder(@RequestBody Order order) {
        return kafkaProducer.sendMessage(order);
    }
}