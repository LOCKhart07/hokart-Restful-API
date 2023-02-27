package com.lti.hokart.service;

import com.lti.hokart.exception.ProductNotFoundException;
import com.lti.hokart.model.AppUser;
import com.lti.hokart.model.Order;
import com.lti.hokart.model.Product;
import com.lti.hokart.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order createOrder(Order order) {
        order.setStatus("inCart");
        return orderRepository.save(order);
    }

    @Override
    public Order deleteOrder(int id) {
        Order order = getOrderById(id);
        orderRepository.delete(order);
        return order;
    }

    @Override
    public Order placeOrder(int id) {
        Order order = getOrderById(id);
        order.setStatus("placed");
        orderRepository.save(order);
        return order;
    }

    @Override
    public Order getOrderById(int id) {
        Optional<Order> product = orderRepository.findById(id);

        if (product.isEmpty()) {
            String errorMessage = "Order with ID:" + id + " not found";
            LOGGER.warn(errorMessage);
            throw new ProductNotFoundException(errorMessage);
        }

        LOGGER.info("Fetched order by id");
        return product.get();
    }

    @Override
    public List<Order> getOrdersByUser(AppUser appUser) {
        List<Order> orders = orderRepository.findByUser_AppUserId(appUser);
        if (orders.isEmpty()) {
            String errorMessage = "No orders for that user exist";
            LOGGER.warn(errorMessage);
            throw new ProductNotFoundException(errorMessage);
        }
        LOGGER.info("Fetched all orders for this user");
        return orders;
    }
}
