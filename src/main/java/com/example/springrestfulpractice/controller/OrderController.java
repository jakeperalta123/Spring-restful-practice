package com.example.springrestfulpractice.controller;

import com.example.springrestfulpractice.model.Order;
import com.example.springrestfulpractice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderservice;

    @GetMapping()
    public List<Order> getAllOrders() {
        List<Order> orderList = this.orderservice.getAllOrders();
        return orderList;
    }

    @GetMapping("/{id}")
    public Order getOrderBySeq(@PathVariable int id) {
        Order order = (Order) this.orderservice.getOrder(id);
        return order;
    }

    @PostMapping()
    public Order createOrder(@RequestBody Order order) {
        return this.orderservice.createOrder(order);
    }

    @PutMapping("/{seq}")
    public Order updateOrder(@PathVariable int seq, @RequestBody Order order) {
        Order updateuser = this.orderservice.updateOrder(seq, order);
        return updateuser;
    }

    @DeleteMapping("/{seq}")
    public Order deleteOrder(@PathVariable int seq) {
        Order deleteOrder = this.orderservice.deleteOrder(seq);
        return deleteOrder;
    }


}
