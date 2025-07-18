package com.example.OrderService.Controller;

import com.example.OrderService.Model.Order;
import com.example.OrderService.Repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PostMapping("/delete")
    public String deleteOrder(@RequestParam Long id){
        Optional<Order> deletedOrder = orderRepository.findById(id);
        if (deletedOrder.equals(Optional.empty()))
        {
            return "No such order with id " + id;
        }
        orderRepository.deleteById(id);
        return "Success, you deleted order: " + deletedOrder.get();

    }

    @PostMapping("/clear")
    public String clearOrders(){
        orderRepository.clearAll();
        return "Success";
    }
}
