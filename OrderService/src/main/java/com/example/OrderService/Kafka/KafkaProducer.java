package com.example.OrderService.Kafka;

import com.example.OrderService.Kafka.Events.OrderCreatedEvent;
import com.example.OrderService.Model.Order;
import com.example.OrderService.Repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class KafkaProducer {

    private final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

    private final KafkaTemplate<String, Long> kafkaTemplate;
    @Autowired
    private OrderRepository orderRepository;

    public KafkaProducer(KafkaTemplate<String, Long> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public String createOrder(Order order){
        Order savedOrder = orderRepository.save(order);

        kafkaTemplate.send("OrderCreated", order.getId());

        logger.info(String.format("Уведомление: заказ номер %d был создан", order.getId()));

        return "Success";
    }
}