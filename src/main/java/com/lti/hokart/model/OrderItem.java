package com.lti.hokart.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "order_item")
public class OrderItem {
    @Id
    @GenericGenerator(name = "orderitem_sequence", strategy = "increment")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderitem_sequence")
    private int orderItemId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productId;
}
