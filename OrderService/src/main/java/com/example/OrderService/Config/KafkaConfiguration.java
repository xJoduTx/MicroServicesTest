package com.example.OrderService.Config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfiguration {

    @Bean
    public NewTopic newTopic(){
        return new NewTopic("orders",1, (short) 1); // название, партиции (части для сохранности данных и ускорения работы брокера сообщений, которые хранят копии сообщений в потоке)
    }
}
