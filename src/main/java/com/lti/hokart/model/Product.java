package com.lti.hokart.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "product")
public class Product {
	
	@NotNull(message = "Product name is required.")
    @Basic(optional = false)
    private String name;

    public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public void setId(Long id) {
	}

	public void setPrice(Double price) {
	}

	@Id
    @GenericGenerator(name = "product_sequence", strategy = "increment")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
    @Column(name = "product_id")
    private int productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price")
    private double productPrice;

    @Column(name = "product_availability")
    private boolean productAvailability;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    public Product(int id, String name, double price, boolean productAvailability, Category category) {
        this.productId = id;
        this.productName = name;
        this.productPrice = price;
        this.category = category;
        this.productAvailability = productAvailability;
    }

    public Product(int id, String name, double price, boolean productAvailability) {
        super();
        this.productId = id;
        this.productName = name;
        this.productPrice = price;
        this.productAvailability = productAvailability;
    }

    public Product() {
        super();
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + this.productId + ", name='" + this.productName + '\'' + '}';
    }

    public int getId() {
        return productId;
    }

    public void setId(int id) {
        this.productId = id;
    }

    public String getName() {
        return productName;
    }

    public void setName(String name) {
        this.productName = name;
    }

    public double getPrice() {
        return productPrice;
    }

    public void setPrice(double price) {
        this.productPrice = price;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isProductAvailability() {
        return productAvailability;
    }

    public void setProductAvailability(boolean productAvailability) {
        this.productAvailability = productAvailability;
    }
}
