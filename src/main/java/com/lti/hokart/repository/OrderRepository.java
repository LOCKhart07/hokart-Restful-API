package com.lti.hokart.repository;

import java.util.Date;
import java.util.List;

import com.lti.hokart.model.Order;
import com.lti.hokart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

	List<Order> findByOrderDateBetween(Date startDate, Date endDate) ;
//	List<Product> findByCategoryCategoryId(int CategoryId);

}
