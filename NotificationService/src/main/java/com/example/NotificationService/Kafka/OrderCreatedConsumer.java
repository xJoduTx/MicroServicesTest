package com.example.NotificationService.Kafka;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderCreatedConsumer {

    private final Logger logger = LoggerFactory.getLogger(OrderCreatedConsumer.class);

    @KafkaListener(topics = "OrderCreated", groupId = "notification-group")
    public void handleOrderCreated(Long id){
        logger.info(String.format("Уведомление: заказ номер %d был создан", id));
    }
}