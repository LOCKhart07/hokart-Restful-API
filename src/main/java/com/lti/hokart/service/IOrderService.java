package com.lti.hokart.service;

import com.lti.hokart.model.AppUser;
import com.lti.hokart.model.Order;

import java.util.List;

public interface IOrderService {
    Order createOrder(Order order);

    Order deleteOrder(int id);

    Order placeOrder(int id);

    Order getOrderById(int id);

    List<Order> getOrdersByUser(AppUser appUser);
}
