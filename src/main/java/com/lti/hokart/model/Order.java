package com.lti.hokart.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GenericGenerator(name = "order_sequence", strategy = "increment")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_sequence")
    @Column(name = "order_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "app_user_id", nullable = false)
    private AppUser user;

    @Column(name = "order_date", nullable = false)
    private Date orderDate;

    @Column(name = "status", nullable = false)
    private String status;

    public int getId() {
        return id;
    }

    public Order(int id, AppUser user, Date orderDate, String status) {
        super();
        this.id = id;
        this.user = user;
        this.orderDate = orderDate;
        this.status = status;
    }

    public Order(){
        super();
    }


    public void setId(int id) {
        this.id = id;
    }


    public AppUser getUser() {
        return user;
    }


    public void setUser(AppUser user) {
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
