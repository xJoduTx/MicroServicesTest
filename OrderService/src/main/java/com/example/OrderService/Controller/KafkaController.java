//package com.example.OrderService.Controller;
//
//import com.example.OrderService.Kafka.KafkaProducer;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api")
//public class KafkaController {
//
//    private final KafkaProducer kafkaProducer;
//    private final KafkaTemplate<String, String> kafkaTemplate;
//
//    public KafkaController(KafkaProducer kafkaProducer, KafkaTemplate<String, String> kafkaTemplate) {
//        this.kafkaProducer = kafkaProducer;
//        this.kafkaTemplate = kafkaTemplate;
//    }
//
//    @PostMapping("/send")
//    public String send(@RequestBody String message) {
//        String event = String.format(message);
//        kafkaProducer.sendMessage(event);
//        return event;
//    }
//}
