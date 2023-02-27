package com.lti.hokart.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lti.hokart.Repository.OrderRepository;
import com.lti.hokart.Repository.UserRepository;
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
	    
	    public int getTotalUserCount() {
	        return UserRepository.count();
	    }
	    
	    public int getActiveUserCountByDateRange(Date startDate, Date endDate) {
	        return UserRepository.countByLastLoginDateBetween(startDate, endDate);
	    }
	    
	    
	    
	}