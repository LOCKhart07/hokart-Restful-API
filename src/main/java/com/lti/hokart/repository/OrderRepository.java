package com.lti.hokart.repository;

import java.util.Date;
import java.util.List;

import com.lti.hokart.model.AppUser;
import com.lti.hokart.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

	List<Order> findByOrderDateBetween(Date startDate, Date endDate) ;
	List<Order> findByUser_AppUserId(AppUser appUser);
}
