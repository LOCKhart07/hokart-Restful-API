package com.lti.hokart.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GenericGenerator(name = "category_sequence", strategy = "increment")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_sequence")
    @Column(name = "category_id")
    int categoryId;

    @Column(name = "category_name")
    String CategoryName;


    public Category(int categoryId, String CategoryName, String imageUrl) {
        super();
        this.categoryId = categoryId;
        this.CategoryName = CategoryName;
    }

    public Category() {
        super();
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {

        return CategoryName;
    }

    public void setCategoryName(String categoryName) {

        this.CategoryName = categoryName;
    }


    @Override
    public String toString() {
    }
}
