package com.example.NotificationService.Kafka;

import com.example.NotificationService.Kafka.Events.OrderCreatedEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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
    public void handleOrderCreated(String event) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        OrderCreatedEvent orderCreatedEvent = mapper.readValue(event, OrderCreatedEvent.class);

        logger.info(String.format("Уведомление: заказ номер %d создан! Товар: %s, Время: %s%n",
                orderCreatedEvent.getOrderId(),
                orderCreatedEvent.getProductName(),
                orderCreatedEvent.getCreatedAt()));
    }
}