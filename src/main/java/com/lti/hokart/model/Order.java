package com.lti.hokart.model;

import java.util.Date;

import org.apache.catalina.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
	@Table(name = "orders")
	public class Order {
	    
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @ManyToOne
	    @JoinColumn(name = "seller_id", nullable = false)
	    private Seller seller;
	    
	    @ManyToOne
	    @JoinColumn(name = "product_id", nullable = false)
	    private Product product;
	    
	    @ManyToOne
	    @JoinColumn(name = "user_id", nullable = false)
	    private User user;
	    
	    @Column(name = "order_date", nullable = false)
	    private Date orderDate;
	    
	    @Column(name = "status", nullable = false)
	    private String status;
	    
	public Long getId() {
			return id;
		}
		public Order(Long id, Seller seller, Product product, User user, Date orderDate, String status) {
			super();
			this.id = id;
			this.seller = seller;
			this.product = product;
			this.user = user;
			this.orderDate = orderDate;
			this.status = status;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public Seller getSeller() {
			return seller;
		}


		public void setSeller(Seller seller) {
			this.seller = seller;
		}


		public Product getProduct() {
			return product;
		}


		public void setProduct(Product product) {
			this.product = product;
		}


		public User getUser() {
			return user;
		}


		public void setUser(User user) {
			this.user = user;
		}


		public Date getOrderDate() {
			return orderDate;
		}


		public void setOrderDate(Date orderDate) {
			this.orderDate = orderDate;
		}


		public String getStatus() {
			return status;
		}


		public void setStatus(String status) {
			this.status = status;
		}
	public int getTotalPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

}
