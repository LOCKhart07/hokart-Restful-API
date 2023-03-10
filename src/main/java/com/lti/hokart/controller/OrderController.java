package com.lti.hokart.controller;

import com.lti.hokart.model.AppUser;
import com.lti.hokart.model.Order;
import com.lti.hokart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/order"})
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        HttpStatus httpStatus = HttpStatus.OK;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Message", "Order created successfully!");
        return new ResponseEntity<>(orderService.createOrder(order), httpHeaders, httpStatus);
    }

    @RequestMapping(value = "/place/{order_id}", method = RequestMethod.PATCH, produces = "application/json")
    public ResponseEntity<Order> placeOrder(@PathVariable(name = "order_id") int orderId) {
        HttpStatus httpStatus = HttpStatus.OK;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Message", "Order created successfully!");
        return new ResponseEntity<>(orderService.placeOrder(orderId), httpHeaders, httpStatus);
    }

    @RequestMapping(value = "/place/{user_id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List> fetchOrdersForUser(@RequestBody AppUser appUser) {
        List<Order> orders = orderService.getOrdersByUser(appUser);
        HttpStatus httpStatus = HttpStatus.FOUND;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Message", "Here are the orders");
        return new ResponseEntity<>(orders, httpHeaders, httpStatus);
    }
}
