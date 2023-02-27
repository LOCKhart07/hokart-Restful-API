package com.lti.hokart.controller;

import com.lti.hokart.model.Order;
import com.lti.hokart.model.Product;
import com.lti.hokart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
