package com.lti.hokart.service;

import java.util.Date;
import java.util.List;

import com.lti.hokart.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import com.lti.hokart.model.Order;

public class Analytics {
	    
	    @Autowired
	    private OrderRepository orderRepository;
	    
	    public List<Order> getOrdersByDateRange(Date startDate, Date endDate) {
	        return orderRepository.findByOrderDateBetween(startDate, endDate);
	    }
	    
	    public int getTotalSalesByDateRange(Date startDate, Date endDate) {
	        List<Order> orders = getOrdersByDateRange(startDate, endDate);
	        int totalSales = 0;
	        for (Order order : orders) {
	            totalSales += order.getTotalPrice();
	        
	        }
	        return totalSales;
	    }
	    
	    
	}