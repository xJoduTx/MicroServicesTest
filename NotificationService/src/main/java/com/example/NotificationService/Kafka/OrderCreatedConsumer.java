package com.example.NotificationService.Kafka;

import com.example.NotificationService.Kafka.Events.OrderCreatedEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderCreatedConsumer {

    @KafkaListener(topics = "order_created", groupId = "notification-group")
    public void handleOrderCreated(String event) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        OrderCreatedEvent orderCreatedEvent = mapper.readValue(event, OrderCreatedEvent.class);
        System.out.println(orderCreatedEvent);

//        System.out.println(orderCreatedEvent);
//        System.out.println(event);
//        System.out.printf("Уведомление: заказ %d создан! Товар: %s, Время: %s%n",
//                event.getOrderId(),
//                event.getProductName(),
//                event.getCreatedAt());
    }
}