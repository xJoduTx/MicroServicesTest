package com.example.OrderService.Controller;

import com.example.OrderService.Model.Order;
import com.example.OrderService.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/all")
    public List<Order> getAllUsers() {
        return orderRepository.findAll();
    }

    @PostMapping("/save")
    public String saveOrder(@RequestBody Order body){
        orderRepository.save(body);
        return "Succes";
    }
}
